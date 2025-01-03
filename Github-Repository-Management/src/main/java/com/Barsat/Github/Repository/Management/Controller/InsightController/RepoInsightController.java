package com.Barsat.Github.Repository.Management.Controller.InsightController;

import com.Barsat.Github.Repository.Management.DTO.LinesOfCodeDTO;
import com.Barsat.Github.Repository.Management.Service.Insights.GithubRepoInsightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/easyrepo/insights/repo")
public class RepoInsightController {

    private final GithubRepoInsightService githubRepoInsightService;

    public RepoInsightController(GithubRepoInsightService githubRepoInsightService) {
        this.githubRepoInsightService = githubRepoInsightService;
    }

    @GetMapping("/{repoName}")
    public List<LinesOfCodeDTO> repoInsight(@PathVariable String repoName) {
        return githubRepoInsightService.getTotalLinesOfCode(repoName);

    }


}
