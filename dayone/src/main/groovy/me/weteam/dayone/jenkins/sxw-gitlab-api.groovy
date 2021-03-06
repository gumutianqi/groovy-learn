/*
 * Copyright (c) 2018. sxw.cn Inc. All Rights Reserved.
 */

package me.weteam.dayone.jenkins

import org.gitlab4j.api.Constants
import org.gitlab4j.api.GitLabApi
import org.gitlab4j.api.models.Project
import org.gitlab4j.api.models.Tag

/**
 * 通过 gitLab-Api 操作 Git
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2018/12/29 19:03
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */

def gitlab_host = "http://git.sxw.cn"

def api_token = "3T83xAEbYos1gjnFBfto"

GitLabApi gitlab = new GitLabApi(GitLabApi.ApiVersion.V3, gitlab_host,
        Constants.TokenType.PRIVATE, api_token)

def namespace = "sxw-java"
def project_name = "platform-service"

def projects = []
gitlab.getProjectApi().getProjects("-service").each { item ->
    projects.push("${item.namespace.name}/${item.name}")
}

projects.sort().each {name ->
    println "\"${name}\","
}

return ""






