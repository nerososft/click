<<<<<<< HEAD

=======
>>>>>>> 6bdf8a2422edfd15d910c44a5674e552460cea0d
#!/bin/bash
echo $1 "starting..."
sudo java -XX:-UseGCOverheadLimit -Xmx1024m -jar ../lib/$1_jar/$1.jar
