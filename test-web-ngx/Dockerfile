FROM node:latest as builder
COPY . /app
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm i
RUN npm run build

#FROM nginx:latest-alphine
#EXPOSE 8080
#COPY --from=builder /app/dist/test-web-ngx /usr/share/nginx/html
