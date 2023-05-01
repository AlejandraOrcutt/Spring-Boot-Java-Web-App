package com.promineoFinal.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.promineoFinal.model.Group;
import com.promineoFinal.repository.GroupRepository;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Service

public class GroupServiceImpl implements GroupService {
  private GroupRepository groupRepository;
  
  public GroupServiceImpl(GroupRepository groupRepository) {
     this.groupRepository = groupRepository;
}

  @Override
  public List<Group> getAllGroups() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Group getGroupByID(Long groupId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Group saveGroup(Group group) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteGroup(Long groupId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Group updateGroup(Group group, Long groupId) {
    // TODO Auto-generated method stub
    return null;
  }

}