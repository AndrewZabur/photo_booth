# Software Management Application for Photo Booths

This application provides a software management system for photo booths, including functionalities such as sentence reversal, order handling, and tax calculation.

## Challenges (Requirements) Met

### Challenge 1: Mirror, Mirror on the Screen!
The `POST /reversed-sentence` endpoint takes a sentence as input and returns the sentence with the order of the words reversed. This caters to the reflective display screen requirement in our latest line of photo booths.

### Challenge 2: I’m feeling lucky!
The `POST /order` endpoint allows a customer to order a photo package. If the customer orders each package type, the application randomly determines whether the customer wins the free prints. This adds an element of fun and chance to the photo booth experience.

### Challenge 3: Only two things in life are guaranteed…
The `POST /tax` endpoint calculates the amount of sales tax owed based on the total revenue from photo booth orders for a given month. This simplifies the process of calculating taxes owed to the IRS, allowing us to focus on the fun aspects of running photo booths. Free orders are not considered in this tax calculation.


## Main Features

1. Sentence Reversal:
    - Get all reversed sentences (GET request to /all-reversed-sentences)
    - Reverse a sentence (POST request to /reversed-sentence)

2. Order Handling:
    - Place an order (POST request to /order)

3. Tax Calculation:
    - Calculate tax (POST request to /tax)

## Getting Started

To get the application up and running, you'll need Docker installed on your machine and two essential configuration files that are not included in the repository due to security reasons:

- `env.properties` file in the `src/main/resources` directory
- `.env` file in the project's root directory

### Prerequisites

- Docker: You can download it from https://www.docker.com/products/docker-desktop.

### Installation and Running the Application

1. Clone the repository: `git clone https://github.com/AndrewZabur/photo_booth.git`
2. Navigate to the project's root directory: `cd photo_booth`
3. Create `env.properties` in the `src/main/resources` directory and `.env` file in the project's root directory with your configuration settings.
4. Run the application: `docker compose up`

## Database Management

We use Flyway for version control for our database. Flyway manages and organizes database migration scripts and ensures the database schema is in sync with the application codebase.

## API Documentation

The complete API documentation for this project is available on Swagger. Once the application is running, navigate to `<hostname>:<port>/swagger-ui.html` on your browser to access the Swagger UI.

For example, if the application is running locally on port 8080, the Swagger UI will be available at `http://localhost:8080/swagger-ui.html`.
