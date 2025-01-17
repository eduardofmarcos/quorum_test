# Assignment Report

## 1. Discuss your strategy and decisions implementing the application.Please, consider time complexity, effort cost, technologies used, and any other variable that you understand.

My first assessment before implementing the solution was to analyze the initial problem and think about how to solve it. The task required transforming a series of structured data into meaningful information for the end user. Another detail I considered was that Quorum uses web scraping to collect data since the raw data comes from various sources. Based on this, I opted for a Java framework called Quarkus.

### Why Quarkus:
- **Cloud-Based Services**: Quarkus is probably the best alternative in Java due to its fast warm-up time and native compilation capabilities using GraalVM.
- **Previous Experience**: In my past experience, we operated web crawlers on ephemeral instances in AWS (almost 200 machines running simultaneously) in plain Java. The warm-up time and resource usage of Java were significant issues, and the switch to Quarkus brought substantial improvements.
- **Multithreaded Java Ecosystem**: Quarkus leverages the advantages of Java’s multithreading capabilities, allowing for efficient parsing of large volumes of data.

---

## 2. How would you change your solution to account for future columns that might be requested, such as “Bill Voted On Date” or “Co-Sponsors”?

### Database-Level Changes:
I would suggest using a **database versioning tool** to track changes in the schema. For example, **Liquibase**, a language-agnostic tool, enables controlled and versioned schema changes while maintaining consistency through change logs.

### Code-Level Changes:
- **“Bill Voted On Date”**: This wouldn’t require significant modifications, assuming that we are already persisting the insertion dates into the database.
- **“Co-Sponsors”**: We would likely need to make changes to the `Bill` entity to accommodate this new field.

---

## 3. How would you change your solution if instead of receiving CSVs of data, you were given a list of legislators or bills that you should generate a CSV for?

Since we are persisting data in a relational database:
1. **Analyze the Structure**: I would first analyze how the list is structured and identify the required data.
2. **Generate the CSV**: Once the data is structured, I would create a service to generate a CSV based on the list of legislators or bills.

---

## 4. How long did you spend working on the assignment?
**3.5 hours**