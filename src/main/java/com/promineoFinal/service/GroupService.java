package com.promineoFinal.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineoFinal.model.Group;

@Component
@Service
public interface GroupService {

  List<Group> getAllGroups();

  Group getGroupByID(Long groupId);

  Group saveGroup(Group group);

  void deleteGroup(Long groupId);

  Group updateGroup(Group group, Long groupId);


}
