package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entities.Publication;
import com.example.demo.repository.PublicationRepository;


@SpringBootApplication
@EnableDiscoveryClient
public class PublicationApplication implements CommandLineRunner{
	@Autowired
	PublicationRepository publicationRepository;
	
	/*@Autowired
	IMemberService memberService;*/
	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
		Date date1= dateFormatter.parse("2022-11-17");
		Date date2= dateFormatter.parse("2022-11-18");
		Publication pub1= new Publication("entertainement","pub1","lien1",date1,"pdf1");
		Publication pub2= new Publication("entertainement","pub1","lien1",date2,"pdf1");

		publicationRepository.save(pub1);
		publicationRepository.save(pub2);

		
		//afficher tous les publications:
		List<Publication> pubs=publicationRepository.findAll();
		for (Publication pub:pubs) {
			System.out.println(pub.getTitre()+" de type: "+pub.getType());
		}
		
		//chercher une pub par ID
		Publication pb=publicationRepository.findById(1L).get();
		System.out.println(pb.getTitre());
		
		//modifier son lien
		pb.setLien("pub.com");
		publicationRepository.save(pb);
		
		
	}

}
