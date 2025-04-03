# Ease-Commerce-UI-Automation

## Installations Required for Local Run
Ensure the following are installed before running the tests:

- **Java 8+**
- **Maven** (Build tool)
- **IDE**: VS Code / IntelliJ / Eclipse  

## Running Tests Locally
1. Add `@test` on top of the scenario to be executed.
2. Run the following command: mvn test -Dcucumber.options="--tags @test"
3. Reports can be found at: target/karate-reports/karate-summary.html
