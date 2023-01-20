
# sample-openwebstart

Experiments with OpenWebStart

## Maven

~~~
$ mvn clean verify

$ java -cp 'target/codebase/*' \
  com.github.phoswald.sample.SwingApplication

$ docker run -it --rm \
  -p 8080:80 \
  -v $(pwd)/target/codebase:/usr/share/nginx/html \
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

## TODO
  
- JARs should be signed
- JARs should not have to be listed manually in JNLP file.
