FROM node:latest as builder

WORKDIR /app
COPY test-web-ngx/package.json test-web-ngx/package-lock.json ./
RUN npm i
COPY . /app
# WORKDIR test-web-ngx
RUN npm run build

FROM nginx:latest
COPY --from=builder /app/dist/frontend /usr/share/nginx/html
EXPOSE 50001
# Start the nginx server
CMD ["nginx", "-g", "daemon off;"]

#FROM nginx:latest-alphine
#EXPOSE 8080
#COPY --from=builder /app/dist/test-web-ngx /usr/share/nginx/html
