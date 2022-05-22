package com.folautech.chat.service;

import java.util.List;
import com.folautech.chat.model.Conversation;
import com.folautech.chat.model.CoversationCreateRequest;
import com.folautech.chat.model.Customer;
import com.folautech.chat.model.SupportTeam;

public interface ChatService {

  Conversation create(CoversationCreateRequest coversationCreateRequest);

  List<Customer> getAllCustomers();

  List<SupportTeam> getSupportTeams();

  List<Conversation> getCustomerConversations(int customerId);

  List<Conversation> getSupportTeamConversations(int teamId);

}
