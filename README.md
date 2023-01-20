
# sample-openwebstart

Experiments with OpenWebStart

## Maven

Links:

- https://www.mojohaus.org/webstart/webstart-maven-plugin/jnlp-single-mojo.html
- https://www.mojohaus.org/webstart/webstart-maven-plugin/examples/default-jnlp-servlet-template.vm

~~~
$ mvn clean verify
$ cat target/jnlp/sample.jnlp

$ java -cp 'target/jnlp/*' \
  com.github.phoswald.sample.SwingApplication

$ docker run -it --rm \
  -p 8080:80 \
  -v $(pwd)/target/jnlp:/usr/share/nginx/html \
  -v $(pwd)/src/main/resources/index.html:/usr/share/nginx/html/index.html \
  nginx:alpine
  
$ curl 'http://localhost:8080/sample.jnlp' -I
$ curl 'http://localhost:8080/sample-openwebstart-0.1.0-SNAPSHOT.jar' -I

$ javaws 'http://localhost:8080/sample.jnlp'
~~~

URLs:

- http://localhost:8080/

## Installation (Linux, Debian-based)

Links:

- https://openwebstart.com/

Installation:

- Download Debian package and install using: `$ dpkg -i OpenWebStart_linux_1_7_0.deb`
- Verify installation: `$ which javaws` 
  (returns `/usr/local/bin/javaws` which points to `/opt/OpenWebStart/javaws`)

Notes:

- `javaws` automatically downloads the correct JVM (adoptium_17.0.5_x64) if not yet present.
- The "OpenWebStart Settings" application can be used to manage JVMs, caches, certificates, logging, and more
- JVMs and applications are are cached under `~/.cache/icedtea-web`
- Settings are stored under `~/.config/icedtea-web/`

## Resulting JNLP file:

Generated from `src/main/jnlp/template.vm`:

~~~
<?xml version="1.0" encoding="UTF-8"?>
<jnlp spec="1.0+" codebase=".">
  <information>
    <title>Sample Application</title>
    <vendor>Sample Corporation</vendor>
    <homepage href="https://github.com/phoswald/sample-openwebstart"/>
    <description>Sample for OpenWebStart</description>
  </information>
  <resources>
    <j2se version="1.8+"/>
         
    <jar href="sample-openwebstart-0.1.0-SNAPSHOT.jar" main="true"/>
    <jar href="slf4j-api-2.0.6.jar"/>
    <jar href="slf4j-simple-2.0.6.jar"/>

     
  </resources>
  <application-desc main-class="com.github.phoswald.sample.SwingApplication"/>
</jnlp>
~~~

## TODO
  
- JARs should be signed
