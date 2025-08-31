package org.dfs.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileNodeService {
        private final List<String> fileNodeAddresses = List.of(
                "dfs-file-node1:8082",
                "dfs-file-node2:8083",
                "dfs-file-node3:8084"
        );
        private int nextNodeIndex = 0;

        public String getNextNodeAddress() {
            String address = fileNodeAddresses.get(nextNodeIndex);
            nextNodeIndex = (nextNodeIndex + 1) % fileNodeAddresses.size();
            return address;
        }

    public String getReplicaNodeAddress(String primaryNodeAddress) {
        int primaryIndex = fileNodeAddresses.indexOf(primaryNodeAddress);
        if (primaryIndex == -1) {
            return getNextNodeAddress();
        }

        int replicaIndex = (primaryIndex + 1) % fileNodeAddresses.size();
        return fileNodeAddresses.get(replicaIndex);
    }
}
