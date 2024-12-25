package com.Barsat.Github.Repository.Management.Controller.RepoCollections;


import com.Barsat.Github.Repository.Management.Service.TreeServices.GetRepoSHAKey;
import com.Barsat.Github.Repository.Management.Service.OAuthService.OAuthService;
import com.Barsat.Github.Repository.Management.Service.TreeServices.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
     private OAuthService oAuthService;

    @Autowired
    private GetRepoSHAKey getRepoSHAKey;

    @Autowired
    private TreeService treeService;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getCommit")
    public String getCommit() {
        return getRepoSHAKey.getSHA();
    }

    @GetMapping("/getTree/{repoId}")
    public String getTree(@PathVariable Integer repoId) {
        return treeService.getTree(repoId);

//        return "hello";


    }


}
