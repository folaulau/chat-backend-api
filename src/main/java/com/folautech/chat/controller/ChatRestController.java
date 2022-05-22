package com.folautech.chat.controller;

import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.folautech.chat.model.Conversation;
import com.folautech.chat.model.CoversationCreateRequest;
import com.folautech.chat.model.Customer;
import com.folautech.chat.model.SupportTeam;
import com.folautech.chat.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Chats", description = "Chat Operations")
@Slf4j
@RestController
@RequestMapping("/chats")
public class ChatRestController {

  @Autowired
  private ChatService chatService;

  @Operation(summary = "Create Conversation")
  @PostMapping(value = "/create/conversation")
  public ResponseEntity<Conversation> createConversation(
      @RequestBody CoversationCreateRequest coversationCreateRequest) {
    log.info("coversationCreateRequest={}", coversationCreateRequest.toString());

    Conversation conversation = chatService.create(coversationCreateRequest);

    return new ResponseEntity<>(conversation, OK);
  }



  @Operation(summary = "Get Customers")
  @GetMapping(value = "/customers")
  public ResponseEntity<List<Customer>> getCustomers() {

    List<Customer> customers = chatService.getAllCustomers();

    return new ResponseEntity<>(customers, OK);
  }

  @Operation(summary = "Get Support Teams")
  @GetMapping(value = "/teams")
  public ResponseEntity<List<SupportTeam>> getSupportTeams() {

    List<SupportTeam> teams = chatService.getSupportTeams();

    return new ResponseEntity<>(teams, OK);
  }

  @Operation(summary = "Get Customer Conversations")
  @GetMapping(value = "/customer-conversations")
  public ResponseEntity<List<Conversation>> getCustomerConversations(@RequestParam int customerId) {

    List<Conversation> convos = chatService.getCustomerConversations(customerId);

    return new ResponseEntity<>(convos, OK);
  }
  
  @Operation(summary = "Get Support Team Conversations")
  @GetMapping(value = "/supportteam-conversations")
  public ResponseEntity<List<Conversation>> getSupportTeamConversations(@RequestParam int teamId) {

    List<Conversation> convos = chatService.getSupportTeamConversations(teamId);

    return new ResponseEntity<>(convos, OK);
  }
  
//  @Operation(summary = "Get Conversation")
//  @GetMapping(value = "/conversation")
//  public ResponseEntity<Conversation> getConversation(@RequestParam int customerId, @RequestParam int teamId) {
//
//    Conversation convo = chatService.getConversation(customerId, teamId);
//
//    return new ResponseEntity<>(convo, OK);
//  }
  
//  @Operation(summary = "Get Support Team Conversations")
//  @GetMapping(value = "/supportteam-conversations")
//  public ResponseEntity<List<Conversation>> getSupportTeamConversations(@RequestParam int teamId) {
//
//    List<Conversation> convos = chatService.getSupportTeamConversations(teamId);
//
//    return new ResponseEntity<>(convos, OK);
//  }
}
