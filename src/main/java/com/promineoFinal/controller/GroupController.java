package com.promineoFinal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineoFinal.model.Group;
import com.promineoFinal.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/musical_groups/musical_groups")
@Api(value = "GroupController", tags = {"Groups"})
public class GroupController {

  @Autowired
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        super();
        this.groupService = groupService;
    }

    @GetMapping
    @ApiOperation(value = "Get all groups", notes = "Get a list of all groups")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("{group_id}")
    @ApiOperation(value = "Get group by ID", notes = "Get group details by ID")
    public ResponseEntity<Group> getGroupById(
            @PathVariable("group_id") @ApiParam(value = "Group ID", example = "1") Long groupId) {
        return new ResponseEntity<Group>(groupService.getGroupByID(groupId), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a group", notes = "Create a new group")
    public ResponseEntity<Group> saveGroup(@RequestBody Group group) {
        return new ResponseEntity<Group>(groupService.saveGroup(group), HttpStatus.CREATED);
    }

    @PutMapping("{group_id}")
    @ApiOperation(value = "Update group", notes = "Update group details by ID")
    public ResponseEntity<Group> updateGroup(
            @PathVariable("group_id") @ApiParam(value = "Group ID", example = "1") Long groupId,
            @RequestBody Group group) {
        return new ResponseEntity<Group>(groupService.updateGroup(group, groupId), HttpStatus.OK);
    }

    @DeleteMapping("{group_id}")
    @ApiOperation(value = "Delete groupt", notes = "Delete group by ID")
    public ResponseEntity<String> deleteGroup(
            @PathVariable("group_id") @ApiParam(value = "Group ID", example = "1") Long groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<String>("Group Gone!!!", HttpStatus.OK);
    }
}

