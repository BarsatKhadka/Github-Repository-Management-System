package com.Barsat.Github.Repository.Management.Controller.CommitController;

import com.Barsat.Github.Repository.Management.DTO.CommitGraphDTO;
import com.Barsat.Github.Repository.Management.Service.CommitGraph.CommitGraphService;
import com.Barsat.Github.Repository.Management.Service.OAuthService.OAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("easyrepo/getCommitGraph")
public class GetCommitGraphController {

    private final CommitGraphService commitGraphService;
    private final OAuthService oAuthService;

    public GetCommitGraphController(CommitGraphService commitGraphService, OAuthService oAuthService) {
        this.commitGraphService = commitGraphService;
        this.oAuthService = oAuthService;
    }

 //Closed this for right now because i will be implementing a commit plan calender and storing every commit will take too much space , and
    // that way i can't host therefore
//    @GetMapping("/{repoId}")
//    public List<CommitGraphDTO> getCommitGraph(@PathVariable int repoId) {
//        String accessToken = oAuthService.getAccessToken();
//        return commitGraphService.getCommitsOfRepo(accessToken, repoId);
//
//    }
//
}
