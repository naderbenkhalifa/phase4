package tn.benkalifa.kitchenstory.api.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.benkalifa.kitchenstory.api.model.Customer;
import tn.benkalifa.kitchenstory.api.util.Constants;

@Api("customers")
public interface CustomerApi {
	@GetMapping(value = Constants.APP_ROOT + "/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Renvoi la liste des customers", notes = "Cette methode permet de chercher et renvoyer la liste des clients qui existent "
	      + "dans la BDD", responseContainer = "List<Customer>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "La liste des clients / Une liste vide")
	  })
	  List<Customer> findAll();
	
	
	@PostMapping(value = Constants.APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Enregistrer un customer", notes = "Cette methode permet d'enregistrer ou modifier un customer", response =Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet customer cree / modifie"),
	      @ApiResponse(code = 400, message = "L'objet customer n'est pas valide")
	  })
	  Customer save(@RequestBody Customer customer);
	
	@GetMapping(value = Constants.APP_ROOT + "/customers/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Rechercher un customer par ID", notes = "Cette methode permet de chercher un customers par son email", response = Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "Le customer a ete trouve dans la BDD"),
	      @ApiResponse(code = 404, message = "Aucun customer n'existe dans la BDD avec l'email fourni")
	  })
	  
	public Customer findByEmail (@PathVariable("email") String email ) ;

}
