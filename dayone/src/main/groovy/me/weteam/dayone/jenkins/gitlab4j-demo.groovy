#!/usr/bin/env groovy

import org.gitlab4j.api.Constants
import org.gitlab4j.api.GitLabApi

/**
 * gitlab4j demo
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2019/1/5 19:21
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */

def gitlab_host = "http://git.sxw.cn"
def api_token = "3T83xAEbYos1gjnFBfto"

GitLabApi gitlab = new GitLabApi(GitLabApi.ApiVersion.V3, gitlab_host,
        Constants.TokenType.PRIVATE, api_token)

def project_name = "platform-service"

println "version: ${gitlab.version.version}"
println "ApiVersion: ${gitlab.apiVersion.apiNamespace}"

// 取得 ProjectId
def projectId
gitlab.getProjectApi().getProjects(project_name).each { item ->
    if (item.name == project_name) projectId = item.id
}

def tags = []
if (projectId) {
    // 通过 ProjectId 取得 Tags 列表
    gitlab.tagsApi.getTags(projectId).each { tag ->
        tags.push(tag.name)
    }
}

println tags
return tags