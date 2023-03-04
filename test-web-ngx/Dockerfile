FROM node:latest as builder
COPY . /app
WORKDIR /app
COPY test-web-ngx/package.json test-web-ngx/package-lock.json ./
RUN npm i
WORKDIR test-web-ngx
RUN npm run build
RUN npm run start

#FROM nginx:latest-alphine
#EXPOSE 8080
#COPY --from=builder /app/dist/test-web-ngx /usr/share/nginx/html
