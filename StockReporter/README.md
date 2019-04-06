StockReporter will be able to scrape financial data from websites, store that data, and also conduct data analysis on the data for research or to aid in the decision-making process regarding investing.

Setup project
-------------
Step 1: On local, git clone https://github.com/kennylg2/swen_sa_tool.git.

Step 2: Switch to "master" branch.

Step 3: Open "StockReporter" project.

Step 4: You need to add project dependencies. 

  (Netbeans): Right click the project -> properties -> libraries -> Add Jar/Folder and select "jarfiles" folder. 

  (Eclipse): Right click the project -> properties -> Java Build Path -> Add JARs and select the project name and "jarfiles"                folder.

Databases
---------
The application will generate "stockreporter.prod" database with tables, indexes, and views when the application is executed for the first time.

New Database
------------
Use "create_tbl_vw_master_summary.sql" to create master, summary tables, indexes, and summary view.

Use "master_data.sql" to insert initial data into STOCK_TICKER and STOCK_SOURCE tables.
