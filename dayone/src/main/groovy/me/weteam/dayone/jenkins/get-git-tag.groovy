/*
 * Copyright (c) 2018. sxw.cn Inc. All Rights Reserved.
 */

package me.weteam.dayone.jenkins

/**
 * 获取 Git 仓库的 Tag 列表信息
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2018/12/29 17:15
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */

def remote_url = "http://git.sxw.cn/sxw-java/platform-service.git"

def command = [ "/bin/bash", "-c", "git ls-remote --tags " + remote_url + " | awk '{print \$2}' | grep -v '\\^{}\$' | sort -r -V | sed 's@refs/tags/@@'" ]

def process = command.execute()
process.waitFor()

def tags = process.in.text.tokenize("\n")

println command

return tags

