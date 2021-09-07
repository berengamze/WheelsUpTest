mkdir MyFiles
cd MyFiles
touch file1.txt file2.txt file3.txt file4.txt file5.txt file6.txt file7.txt
ls
ls -At | tail -n +4 | xargs rm —
ls
vim file5.txt
"I am file 5" -->Text editor
:q
vim file6.txt
"I am file 6"
:q
vim file7.txt
"I am file 7"
:q
cat file7.txt