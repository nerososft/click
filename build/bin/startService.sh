
#!/bin/bash
echo $1 "starting..."
sudo java -XX:-UseGCOverheadLimit -Xmx1024m -jar ../lib/$1_jar/$1.jar
