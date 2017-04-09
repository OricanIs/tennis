#!/usr/bin/expect -f

set ipaddr "116.62.25.201"

set passwd "Muxu@2017"

set timeout  1 

spawn ssh root@$ipaddr

expect {

"yes/no" { send "yes\r"; exp_continue}

"*password:" { send "$passwd\r" }

}

expect "]# "

send "/usr/local/tomcat/bin/shutdown.sh\r" 

expect "]# "

send "/usr/local/tomcat/bin/startup.sh\r" 

expect "]# "

exit

#!/usr/bin/bash
