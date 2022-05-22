package com.folautech.chat.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.folautech.chat.model.Conversation;
import com.folautech.chat.model.CoversationCreateRequest;
import com.folautech.chat.model.Customer;
import com.folautech.chat.model.Message;
import com.folautech.chat.model.SupportTeam;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Firestore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatServiceImp implements ChatService {

  private List<Customer> customers = new ArrayList<>();
  private List<SupportTeam> supportTeams = new ArrayList<>();
  private Map<String, String> chats = new HashMap<>();

  private Long numberOfUsers = 10L;

  @Autowired
  private Firestore firestore;

  @PostConstruct
  public void init() {
    // for (int cus = 1; cus <= numberOfUsers; cus++) {
    // for (int team = 1; team <= numberOfUsers; team++) {
    // System.out.println("chats.put(\"cust-"+cus+"-team-"+team+"\",
    // \"cust-"+cus+"-team-"+team+"-"+UUID.randomUUID().toString()+"\");");
    // }
    //
    // }

    loadCustomers();
    loadSupportTeams();
    loadChats();
  }

  @Override
  public Conversation create(CoversationCreateRequest request) {

    String convoKey = "cust-" + request.getCustomerId() + "-team-" + request.getSupportTeamId();

    String convoId = chats.get(convoKey);

    // firestore.collection("chat").document(convoId).collection("messages").add("");

    try {
      String id = firestore.collection("chat").document(convoId).collection("messages")
          .add(Message.builder().deleted(true).build()).get().get().get().getId();

      System.out.println("id: " + id);


    } catch (InterruptedException | ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // firestore.collection("chat").document(convoId).collection("messages").add(Message.builder()
    // .message("starting convo")
    // .timestamp(LocalDateTime.now().toString())
    // .sender("team")
    // .build());

    // TODO Auto-generated method stub
    return Conversation.builder().customer(getCustomerById(request.getCustomerId()))
        .supportTeam(getSupportTeamById(request.getSupportTeamId())).id(convoId).build();
  }


  private void loadCustomers() {

    List<String> imageUrls = Arrays.asList(
        "https://www.hollywoodreporter.com/wp-content/uploads/2021/10/Man-of-Steel-Everett-H-2021.jpg",
        "https://variety.com/wp-content/uploads/2022/03/the-batman-1.png",
        "https://venturebeat.com/wp-content/uploads/2018/09/ironman.jpg");

    for (int i = 1; i <= numberOfUsers; i++) {
      customers
          .add(Customer.builder().id(Long.valueOf(i)).name(RandomGeneratorUtils.getRandomFullName())
              .imageUrl(imageUrls.get(RandomGeneratorUtils.getIntegerWithin(0, imageUrls.size())))
              .build());
    }
  }

  private void loadSupportTeams() {
    List<String> imageUrls = Arrays.asList(
        "https://st.depositphotos.com/1258191/3252/i/450/depositphotos_32524605-stock-photo-portrait-of-a-handsome-doctor.jpg",
        "https://st2.depositphotos.com/1158045/6457/i/950/depositphotos_64572953-stock-photo-smiling-doctor-at-hospital.jpg",
        "https://resources.workable.com/wp-content/uploads/2016/06/How-weve-scaled-our-customer-support-team-thumb.png");

    for (int i = 1; i <= numberOfUsers; i++) {
      supportTeams.add(
          SupportTeam.builder().id(Long.valueOf(i)).name(RandomGeneratorUtils.getRandomFullName())
              .imageUrl(imageUrls.get(RandomGeneratorUtils.getIntegerWithin(0, imageUrls.size())))
              .build());
    }
  }

  private void loadChats() {

    chats.put("cust-1-team-1", "cust-1-team-1-3ac0478f-538a-44eb-9ab5-eaa3fa3339e9");
    chats.put("cust-1-team-2", "cust-1-team-2-4006148a-e55b-4027-a27c-07e1acfc534e");
    chats.put("cust-1-team-3", "cust-1-team-3-c22e88ed-fb4a-4439-bfb5-365871b721e2");
    chats.put("cust-1-team-4", "cust-1-team-4-1a526e89-0c03-46ca-96e9-dc368c80e7d6");
    chats.put("cust-1-team-5", "cust-1-team-5-4f911768-9fe7-4c48-b636-f5eef294ded5");
    chats.put("cust-1-team-6", "cust-1-team-6-970eb6f9-073c-47ff-8e4b-8b411fe897bd");
    chats.put("cust-1-team-7", "cust-1-team-7-51c73697-dec3-4d9c-a36f-8005aa7183d6");
    chats.put("cust-1-team-8", "cust-1-team-8-8c40e27f-0f67-449f-890a-396f06f737cb");
    chats.put("cust-1-team-9", "cust-1-team-9-33ba5aaf-db80-4492-94b1-2b0354a335ca");
    chats.put("cust-1-team-10", "cust-1-team-10-6012ed6e-6742-4fe0-96d1-e15d997291d8");
    chats.put("cust-2-team-1", "cust-2-team-1-63993103-d474-47bb-a5c3-cd9d72989e94");
    chats.put("cust-2-team-2", "cust-2-team-2-622de2ab-3596-4d0b-aaad-cb0b71c011eb");
    chats.put("cust-2-team-3", "cust-2-team-3-a0fc9292-0f54-4d7d-876a-c968c21b4a01");
    chats.put("cust-2-team-4", "cust-2-team-4-d81f3ee4-c75a-4476-82d1-26411c1e963a");
    chats.put("cust-2-team-5", "cust-2-team-5-f6c9a207-1134-40a3-90ee-da6fc87d13a2");
    chats.put("cust-2-team-6", "cust-2-team-6-6fe2e741-06dd-4669-ab0b-15dcdc1b909a");
    chats.put("cust-2-team-7", "cust-2-team-7-ad3c7697-55a2-4d9a-a82d-d04fcbc38829");
    chats.put("cust-2-team-8", "cust-2-team-8-44e2ad71-eee4-4a9b-bdd1-0ab72762197e");
    chats.put("cust-2-team-9", "cust-2-team-9-f3f1e280-808f-4e06-8994-c4f12a3c40c7");
    chats.put("cust-2-team-10", "cust-2-team-10-2e90f805-5d0d-483e-9ea0-74b3a6be0abc");
    chats.put("cust-3-team-1", "cust-3-team-1-a95559a7-2759-4ed9-b7fb-5ee7cc5a79b5");
    chats.put("cust-3-team-2", "cust-3-team-2-81781282-1bc3-4be0-b5c7-20b1c5914215");
    chats.put("cust-3-team-3", "cust-3-team-3-712f8f84-bd3b-4ef3-ac82-0e9076668618");
    chats.put("cust-3-team-4", "cust-3-team-4-f2915b04-dac1-4a7c-8b6a-67837cad7152");
    chats.put("cust-3-team-5", "cust-3-team-5-c6266f0f-053b-4b0c-a32e-e5ec4f567fa0");
    chats.put("cust-3-team-6", "cust-3-team-6-43aff5e4-5526-4e95-b3b1-e675235363c6");
    chats.put("cust-3-team-7", "cust-3-team-7-ae803d7e-4eec-4eb8-abf5-7baa67df267a");
    chats.put("cust-3-team-8", "cust-3-team-8-3c9c5ac2-afba-4ecc-a5c0-d9f7b428ae33");
    chats.put("cust-3-team-9", "cust-3-team-9-9171837b-04bd-4cd9-8c50-5d3435f7f99b");
    chats.put("cust-3-team-10", "cust-3-team-10-7218795b-eb77-43fd-94ad-435d231c5d24");
    chats.put("cust-4-team-1", "cust-4-team-1-7dfd50b2-16a6-45d1-8c37-e54f391cc795");
    chats.put("cust-4-team-2", "cust-4-team-2-bf5ab8ee-fad2-4c21-be18-baacb1d21f55");
    chats.put("cust-4-team-3", "cust-4-team-3-d0915b1b-0687-48f3-990a-b367e25bc715");
    chats.put("cust-4-team-4", "cust-4-team-4-5169e4e4-d534-401d-adb3-366f893b236f");
    chats.put("cust-4-team-5", "cust-4-team-5-fa7b044b-3ded-4195-9ed1-50caa565a4f9");
    chats.put("cust-4-team-6", "cust-4-team-6-7003efc3-13a7-4617-9e92-13403696783e");
    chats.put("cust-4-team-7", "cust-4-team-7-6247b382-faeb-478a-b4b5-86e92faf12d7");
    chats.put("cust-4-team-8", "cust-4-team-8-a5882394-ac1e-4d93-9a66-d430dc6eb5dd");
    chats.put("cust-4-team-9", "cust-4-team-9-2f05c930-958b-4471-aaeb-b87b1782fc82");
    chats.put("cust-4-team-10", "cust-4-team-10-df92601d-7620-4ce4-a2b4-b82b556b19d3");
    chats.put("cust-5-team-1", "cust-5-team-1-ce36736f-4e72-456a-982a-846ff87f0d2e");
    chats.put("cust-5-team-2", "cust-5-team-2-a56122cc-596e-4757-970e-c597ef446bed");
    chats.put("cust-5-team-3", "cust-5-team-3-827d7aa3-053c-4617-8091-b886df157c51");
    chats.put("cust-5-team-4", "cust-5-team-4-af8ad6c4-ea7e-42a7-ad9e-3ff16faf043f");
    chats.put("cust-5-team-5", "cust-5-team-5-a6ff0dda-11c9-45c6-8a5c-e2145f86506a");
    chats.put("cust-5-team-6", "cust-5-team-6-d8a1ad14-5b35-4457-bbf4-77abcc3621fc");
    chats.put("cust-5-team-7", "cust-5-team-7-e7bb2d89-d4cf-40d6-a235-38c6638b837a");
    chats.put("cust-5-team-8", "cust-5-team-8-93fb51fe-b9db-4c06-abd7-4bb8af56cc1f");
    chats.put("cust-5-team-9", "cust-5-team-9-cb3c8cc3-ef41-4fc7-b34a-add69c341396");
    chats.put("cust-5-team-10", "cust-5-team-10-a0ae9559-2a20-4d24-a1dd-30e4d288f8bf");
    chats.put("cust-6-team-1", "cust-6-team-1-258f21e8-94d0-40cf-b2ac-4f132874ee3e");
    chats.put("cust-6-team-2", "cust-6-team-2-6ae40d76-628a-4c05-8ee1-283ceae666c8");
    chats.put("cust-6-team-3", "cust-6-team-3-1911cb87-7692-4878-b473-36a10e21320c");
    chats.put("cust-6-team-4", "cust-6-team-4-a9cf295e-beec-490d-864d-2e5b1836cd67");
    chats.put("cust-6-team-5", "cust-6-team-5-f7c82707-b3f1-43f9-b356-dbc74312a439");
    chats.put("cust-6-team-6", "cust-6-team-6-d0220c84-def6-4e6c-94eb-a99741cc419a");
    chats.put("cust-6-team-7", "cust-6-team-7-68269407-0e11-4ead-b97a-8fe3dfbb0892");
    chats.put("cust-6-team-8", "cust-6-team-8-d986fa66-c743-499c-b982-1ed138240669");
    chats.put("cust-6-team-9", "cust-6-team-9-0a778a88-656e-42ec-bda1-125df93dc8a0");
    chats.put("cust-6-team-10", "cust-6-team-10-b9501a01-f21d-43f7-9bb9-0297c5a8a787");
    chats.put("cust-7-team-1", "cust-7-team-1-989e57e4-56e0-4f8c-bd90-73050fbdb0c1");
    chats.put("cust-7-team-2", "cust-7-team-2-1b63d411-ca13-4ac5-97e0-619cffa0554f");
    chats.put("cust-7-team-3", "cust-7-team-3-cf720f20-3c52-4584-bdc2-9c430e2e1e44");
    chats.put("cust-7-team-4", "cust-7-team-4-fcbe64e1-d0e0-4bb0-9463-f6d5dd9b0a0e");
    chats.put("cust-7-team-5", "cust-7-team-5-5447273b-c9f0-46ab-94ab-5e405cc36464");
    chats.put("cust-7-team-6", "cust-7-team-6-ca725742-a9a5-4a93-a7d2-fbe31e081bec");
    chats.put("cust-7-team-7", "cust-7-team-7-413d403e-0e62-4629-b3f0-519811fd0844");
    chats.put("cust-7-team-8", "cust-7-team-8-0f088043-dd04-456c-a34e-430b4f87670e");
    chats.put("cust-7-team-9", "cust-7-team-9-672c051b-b8c5-40b0-b062-ad5833151e6a");
    chats.put("cust-7-team-10", "cust-7-team-10-6aa04e6d-b8d7-43c8-92c5-e40330457b9e");
    chats.put("cust-8-team-1", "cust-8-team-1-6506834a-13cd-4867-8603-21498dc66b1c");
    chats.put("cust-8-team-2", "cust-8-team-2-e3d1da97-d3c7-4042-bb76-9b919b5744da");
    chats.put("cust-8-team-3", "cust-8-team-3-a20fcf4c-3a35-4518-a10e-47382c33f9c3");
    chats.put("cust-8-team-4", "cust-8-team-4-584a6ff5-76c5-4499-a2f9-0484b99935f9");
    chats.put("cust-8-team-5", "cust-8-team-5-04f9c314-6af0-4763-8058-6cc511b2ae2f");
    chats.put("cust-8-team-6", "cust-8-team-6-8884e714-1d0f-4f9a-a6b4-a0f77a81e494");
    chats.put("cust-8-team-7", "cust-8-team-7-ea24b03e-bb03-423f-a139-063e109745ca");
    chats.put("cust-8-team-8", "cust-8-team-8-eeb25c29-670e-42d5-b2b1-750fe0f09081");
    chats.put("cust-8-team-9", "cust-8-team-9-e08559a0-bcf4-4120-83f8-b1b283f176ad");
    chats.put("cust-8-team-10", "cust-8-team-10-5f5f0055-85de-4e40-a39f-9ca0b2555750");
    chats.put("cust-9-team-1", "cust-9-team-1-97acb2f3-049f-4a4e-a5e2-275155bc37fd");
    chats.put("cust-9-team-2", "cust-9-team-2-f9b18d39-71d4-45d0-9e1a-9f4c2aa9420e");
    chats.put("cust-9-team-3", "cust-9-team-3-43911364-e2c6-4194-90da-03b9cbc01ec5");
    chats.put("cust-9-team-4", "cust-9-team-4-60c85491-131c-472e-a5e1-beaa08744233");
    chats.put("cust-9-team-5", "cust-9-team-5-c2a7fc64-3da3-4179-868a-768334867ba4");
    chats.put("cust-9-team-6", "cust-9-team-6-02848fc6-5d07-44fa-be3e-4d88677bb52a");
    chats.put("cust-9-team-7", "cust-9-team-7-b255f4ab-5961-4214-978c-269487c98716");
    chats.put("cust-9-team-8", "cust-9-team-8-17b96d83-67dc-4f04-8d14-29159e50c043");
    chats.put("cust-9-team-9", "cust-9-team-9-4cb99ec6-5e22-4970-ac62-c5e89b6683ee");
    chats.put("cust-9-team-10", "cust-9-team-10-f131e6c0-a54f-46d5-9ea4-b5ef83e670df");
    chats.put("cust-10-team-1", "cust-10-team-1-28f113fa-b990-4a33-8b91-105b0bfe84b7");
    chats.put("cust-10-team-2", "cust-10-team-2-5c8cbc75-bb9f-42ac-bbdc-1391fa76792d");
    chats.put("cust-10-team-3", "cust-10-team-3-c2165ef5-c2c9-430c-a4df-13bc84f32c65");
    chats.put("cust-10-team-4", "cust-10-team-4-840f8c93-addc-4046-8ef8-8389b60898cd");
    chats.put("cust-10-team-5", "cust-10-team-5-cd6dcd8c-4f66-4112-a09d-d7329473285d");
    chats.put("cust-10-team-6", "cust-10-team-6-3534b449-d038-4368-8a44-c84a046197c2");
    chats.put("cust-10-team-7", "cust-10-team-7-d528dde4-ae7a-4eca-9816-15d49797c240");
    chats.put("cust-10-team-8", "cust-10-team-8-6425ceea-ee79-4af5-ab0b-2a81f7b2169d");
    chats.put("cust-10-team-9", "cust-10-team-9-ff28112b-4209-4b0c-a8d5-d4ad54d04961");
    chats.put("cust-10-team-10", "cust-10-team-10-380000e4-2746-431d-a336-bafae1b6c936");
  }

  private Customer getCustomerById(long id) {
    return customers.get(Integer.valueOf(id + ""));
  }

  private SupportTeam getSupportTeamById(long id) {
    return supportTeams.get(Integer.valueOf(id + ""));
  }

  @Override
  public List<Customer> getAllCustomers() {
    // TODO Auto-generated method stub
    return this.customers;
  }

  @Override
  public List<SupportTeam> getSupportTeams() {
    // TODO Auto-generated method stub
    return this.supportTeams;
  }

  @Override
  public List<Conversation> getCustomerConversations(int customerId) {
    List<Conversation> convos = new ArrayList<>();

    Customer customer = getCustomerById(customerId-1);

    for (int teamId = 1; teamId <= numberOfUsers; teamId++) {

      String key = "cust-" + customerId + "-team-" + teamId;

      System.out.println("key: " + key);

      String convoId = chats.get(key);

      SupportTeam team = getSupportTeamById(teamId-1);

      convos.add(Conversation.builder().id(convoId).customer(customer).supportTeam(team).build());
    }

    return convos;
  }

  @Override
  public List<Conversation> getSupportTeamConversations(int teamId) {
    List<Conversation> convos = new ArrayList<>();

    SupportTeam team = getSupportTeamById(teamId-1);

    for (int customerId = 1; customerId <= numberOfUsers; customerId++) {

      String key = "cust-" + customerId + "-team-" + teamId;

      System.out.println("key: " + key);

      String convoId = chats.get(key);

      Customer customer = getCustomerById(customerId-1);

      convos.add(Conversation.builder().id(convoId).customer(customer).supportTeam(team).build());
    }

    return convos;
  }

}
