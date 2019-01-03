/*
 * Copyright (c) 2018. sxw.cn Inc. All Rights Reserved.
 */

package me.weteam.dayone.jenkins

import org.gitlab4j.api.Constants
import org.gitlab4j.api.GitLabApi
import org.gitlab4j.api.models.Project
import org.gitlab4j.api.models.Tag

/**
 * GitLab Api Demo
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2018/12/29 20:47
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */

def gitlab_host = "https://gitlab.com"

def api_token = "jtpuABPFspDPujQpGBVQ"

GitLabApi gitlab = new GitLabApi(GitLabApi.ApiVersion.V4, gitlab_host,
        Constants.TokenType.PRIVATE, api_token)

def namespace = "LarryKoo"
def project_name = "learning-vue"

Project project = gitlab.getProjectApi().getProject(namespace, project_name)

println project.id + project.name + project.description

List<Tag> tagList = gitlab.tagsApi.getTags(project.id)

tagList.each { tag ->
    println tag.name
}

return tagList