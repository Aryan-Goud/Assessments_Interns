package com.service;

import com.model.Status;
import com.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getStatus();
    Status create(Status name);
    //    void insert(Status user);
//    Status check(Status exists)
    Status getStatusId(int id);
    Status updateStatus(Status name);
    Status deleteStatus(int id);
    int search(int sysids);

}
