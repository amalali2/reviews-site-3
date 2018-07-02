# review-site-fullstack

WCCI Project:

First iteration of halalbites.com; a website created for foodies who prefer to adhere to a halal/zabihah diet. 

## Overview

Return to your reviews site from the [previous exercise](../reviews-site) (or create another). All requirements from the previous project still apply. If these aren't present, you will lose points.

## Project Tasks

Feel free to use appropriate class names other than `Review` and `Category`, but these instructions will refer to `Review` and `Category`.

*   Add the following dependencies to `build.gradle` (or use [Spring Initializr](https://start.spring.io/) to create a new `build.gradle`)
    *   [ ] JPA (spring-boot-starter-data-jpa)
    *   [ ] H2
*   Create a `Category` class that:
    *   [ ] is a JPA entity.
    *   [ ] contains an instance variable referencing the `Review`s it contains.
    *   [ ] configures an appropriate JPA relationship to its reviews.
*   Update the `Review` class such that:
    *   [ ] it is a JPA entity.
    *   [ ] configures a JPA relationship to its associated category.
    *   [ ] allows for a description/content/body longer than 255 characters.
*   Update your view (templates/html/css) such that:
    *   [ ] there is a page that lists review categories, each of which links to the (details) page for a specific category.
    *   [ ] there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
    *   [ ] each review detail page has a link to the page for its category.
