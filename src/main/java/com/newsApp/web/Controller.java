package com.newsApp.web;


import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.javaguides.springboot.fileuploaddownload.payload.Response;
import net.javaguides.springboot.fileuploaddownload.service.FileStorageService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newsApp.entities.Categorie;
import com.newsApp.entities.New;
import com.newsApp.repository.CategorieRepository;
import com.newsApp.repository.NewRepository;
import com.newsApp.service.NewService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Controller {
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
      return outputStream.toByteArray();
	}
	
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    
   // private FileStorageService fileStorageService;

    
    //add new
    @PostMapping("/news/add")
    public New AjouterNew(
			@RequestParam(value = "description",required = true) String description,
			@RequestParam(value = "image",required = false) MultipartFile image,
			@RequestParam(value = "title",required = true) String title,
			@RequestParam(value = "category", required = false) String category
    		) throws IOException  {
    	
    	New n = new New();
    	n.setDescription(description);
    	n.setTitle(title);
    	if(category!=null)
    		n.setCategorie(categorieRepository.findByName(category));
    	
    	
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		if(fileName.contains(".."))
			System.out.println("not a valid file");
		try {
			n.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	newRepository.save(n);
    	return n;
    	
    }
    
    //get all news
    @GetMapping("/news/get")
    public List<New> getAllNews(){
    	return this.newRepository.findAll();
    }
    
    //get news by id
 
    @GetMapping("/news/{id}")
    public ResponseEntity<New> getNew(@PathVariable Long id) throws IOException {
    	New n = newRepository.findById(id).get();
    	return ResponseEntity.ok().body(n);
    }
    
    //delete new
    @RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	public boolean deletePost(@PathVariable Long id) {
		newRepository.deleteById(id);
		return true;
	}
    
    //get news by categorie 
    @GetMapping("/news/category/{name}")
    public List<New> getNewByCategory(@PathVariable String name ){
    	return newRepository.findByCategorie(categorieRepository.findByName(name));
    }
      
}
