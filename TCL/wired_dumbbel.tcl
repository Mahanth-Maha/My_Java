# This script is created by NSG2 beta1
# <http://wushoupong.googlepages.com/nsg>

#===================================
#     Simulation parameters setup
#===================================
set val(stop)   10.0                         ;# time of simulation end

#===================================
#        Initialization        
#===================================
#Create a ns simulator
set ns [new Simulator]

#Open the NS trace file
set tracefile [open wired_dumbbel.tr w]
$ns trace-all $tracefile

#Open the NAM trace file
set namfile [open wired_dumbbel.nam w]
$ns namtrace-all $namfile

#===================================
#        Nodes Definition        
#===================================
#Create 12 nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]
set n7 [$ns node]
set n8 [$ns node]
set n9 [$ns node]
set n10 [$ns node]
set n11 [$ns node]

#===================================
#        Links Definition        
#===================================
#Createlinks between nodes
$ns duplex-link $n0 $n1 100.0Mb 50ms DropTail
$ns queue-limit $n0 $n1 50
$ns duplex-link $n0 $n2 25.0Mb 5ms DropTail
$ns queue-limit $n0 $n2 5
$ns duplex-link $n0 $n3 25.0Mb 5ms DropTail
$ns queue-limit $n0 $n3 5
$ns duplex-link $n0 $n4 25.0Mb 5ms DropTail
$ns queue-limit $n0 $n4 5
$ns duplex-link $n0 $n5 25.0Mb 5ms DropTail
$ns queue-limit $n0 $n5 5
$ns duplex-link $n0 $n6 25.0Mb 5ms DropTail
$ns queue-limit $n0 $n6 5
$ns duplex-link $n11 $n1 25.0Mb 5ms DropTail
$ns queue-limit $n11 $n1 5
$ns duplex-link $n7 $n1 25.0Mb 5ms DropTail
$ns queue-limit $n7 $n1 5
$ns duplex-link $n1 $n8 25.0Mb 5ms DropTail
$ns queue-limit $n1 $n8 5
$ns duplex-link $n1 $n9 25.0Mb 5ms DropTail
$ns queue-limit $n1 $n9 5
$ns duplex-link $n10 $n1 25.0Mb 5ms DropTail
$ns queue-limit $n10 $n1 5

#Give node position (for NAM)
$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n0 $n2 orient right-up
$ns duplex-link-op $n0 $n3 orient left-up
$ns duplex-link-op $n0 $n4 orient left

$ns duplex-link-op $n0 $n5 orient left-down
$ns duplex-link-op $n0 $n6 orient left-down
$ns duplex-link-op $n11 $n1 orient left-up
$ns duplex-link-op $n7 $n1 orient left-down
$ns duplex-link-op $n1 $n8 orient right-up
$ns duplex-link-op $n1 $n9 orient right
$ns duplex-link-op $n10 $n1 orient left-up

#===================================
#        Agents Definition        
#===================================
#Setup a TCP connection
set tcp0 [new Agent/TCP]
$ns attach-agent $n2 $tcp0
set sink3 [new Agent/TCPSink]
$ns attach-agent $n7 $sink3
$ns connect $tcp0 $sink3
$tcp0 set packetSize_ 1500

#Setup a TCP connection
set tcp1 [new Agent/TCP]
$ns attach-agent $n4 $tcp1
set sink5 [new Agent/TCPSink]
$ns attach-agent $n9 $sink5
$ns connect $tcp1 $sink5
$tcp1 set packetSize_ 1500

#Setup a TCP connection
set tcp2 [new Agent/TCP]
$ns attach-agent $n6 $tcp2
set sink4 [new Agent/TCPSink]
$ns attach-agent $n11 $sink4
$ns connect $tcp2 $sink4
$tcp2 set packetSize_ 1500

#Setup a UDP connection
set udp6 [new Agent/UDP]
$ns attach-agent $n3 $udp6
set null8 [new Agent/Null]
$ns attach-agent $n8 $null8
$ns connect $udp6 $null8
$udp6 set packetSize_ 1500

#Setup a UDP connection
set udp7 [new Agent/UDP]
$ns attach-agent $n5 $udp7
set null9 [new Agent/Null]
$ns attach-agent $n10 $null9
$ns connect $udp7 $null9
$udp7 set packetSize_ 1500


#===================================
#        Applications Definition        
#===================================
#Setup a FTP Application over TCP connection
set ftp0 [new Application/FTP]
$ftp0 attach-agent $tcp0
$ns at 1.0 "$ftp0 start"
$ns at 4.0 "$ftp0 stop"

#Setup a FTP Application over TCP connection
set ftp1 [new Application/FTP]
$ftp1 attach-agent $tcp2
$ns at 1.0 "$ftp1 start"
$ns at 4.0 "$ftp1 stop"

#Setup a FTP Application over TCP connection
set ftp2 [new Application/FTP]
$ftp2 attach-agent $tcp1
$ns at 1.0 "$ftp2 start"
$ns at 4.0 "$ftp2 stop"

#Setup a CBR Application over UDP connection
set cbr3 [new Application/Traffic/CBR]
$cbr3 attach-agent $udp6
$cbr3 set packetSize_ 1000
$cbr3 set rate_ 1.0Mb
$cbr3 set random_ 
$ns at 1.0 "$cbr3 start"
$ns at 4.0 "$cbr3 stop"

#Setup a CBR Application over UDP connection
set cbr4 [new Application/Traffic/CBR]
$cbr4 attach-agent $udp7
$cbr4 set packetSize_ 1000
$cbr4 set rate_ 1.0Mb
$cbr4 set random_ 
$ns at 1.0 "$cbr4 start"
$ns at 4.0 "$cbr4 stop"


#===================================
#        Termination        
#===================================
#Define a 'finish' procedure
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam wired_dumbbel.nam &
    exit 0
}
$ns at $val(stop) "$ns nam-end-wireless $val(stop)"
$ns at $val(stop) "finish"
$ns at $val(stop) "puts \"done\" ; $ns halt"
$ns run
