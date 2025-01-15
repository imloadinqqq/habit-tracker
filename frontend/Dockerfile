
# Stage 1: Build React App
FROM node:18 as build

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the React app's code
COPY . .

# Build the React app
RUN npm run build

# Stage 2: Serve React App using Nginx
FROM nginx:stable-alpine

# Copy built React app to Nginx's default HTML location
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
