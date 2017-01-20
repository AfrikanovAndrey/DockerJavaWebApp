# Build Java-project and package it to war-file
mvn clean package

# Get variables from config-file
source docker/docker.properties

# Copy packaged war-file to docker directory
if ! [ -f target/${APP_NAME}.war ]; then
    echo "There is not '${APP_NAME}.war' file in target directory."
    exit 1
fi

# Copy (overwrite) war-file to docker directory
cp -f target/${APP_NAME}.war docker

cd docker

# Build docker image
#docker build -t registry.rtty.in/${REPOSITORY}/${APP_NAME}:${VERSION} -t registry.rtty.in/${REPOSITORY}/${APP_NAME}:latest .

# Push docker image to registry
#docker push registry.rtty.in/${REPOSITORY}/${APP_NAME}:${VERSION}
#docker push registry.rtty.in/${REPOSITORY}/${APP_NAME}:latest

