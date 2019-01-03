// groovy script

def remote_url = "git@git.sxw.cn:sxw-java/platform-service.git"

def command = [ "/bin/bash", "-c", "git ls-remote --tags " + remote_url + " | awk '{print \$2}' | grep -v '\\^{}\$' | sort -r -V | sed 's@refs/tags/@@'" ]

def process = command.execute()
process.waitFor()

def tags = process.in.text.tokenize("\n")

println command
println tags
