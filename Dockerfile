FROM airhacks/glassfish
COPY ./target/minimalSelectOneWithEntity.war ${DEPLOYMENT_DIR}
