
#!/usr/bin/expect -f


##同步数据
remote_ip="116.62.25.201"
remote_name="root"
####remoteDir="/usr/local/tomcat/webapps/ROOT/"
remote_dir="/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/"
rsync -e ssh -r ./target/tennis/WEB-INF/classes/* --progress -cv "$remote_name@$remote_ip:$remote_dir"

./restart.sh