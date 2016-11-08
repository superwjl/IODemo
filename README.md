# IODemo
1.字节流

 FileInputStream:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new FileInputStream(filename);
 
 FileOutputStream:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new FileOutputStream(filename, append);
 
 DataOutputStream:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new DataInputStream(new FileInputStream(filename));
 
 DataInputStream:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new DataOutputStream(new FileOutputStream(filename));
 
 BufferedInputStream:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new BufferedInputStream(new FileInputStream(filename));
 
 BufferedOutputStream:&nbsp;&nbsp;new BufferedOutputStream(new FileOutputStream(filename));
 
2.字符流

 InputStreamReader:&nbsp;&nbsp;&nbsp;new InputStreamReader(new FileInputStream(filename), charset);
 
 OutputStreamWriter:&nbsp;&nbsp;new OutputStreamWriter(new FileOutputStream(filename), charset);
 
 FileReader:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new FileReader(filename);
 
 FileWriter:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new FileWriter(filename, append);
 
 BufferedReader:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new BufferedReader(new InputStreamReader(new FileInputStream(filename), charset));
 
 BufferedWriter:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, append), charset));
 
 PrintWriter:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;new PrintWriter(new FileOutputStream(filename, append), autoFlush);
 
 ObjectInputStream:&nbsp;&nbsp;&nbsp;&nbsp;new ObjectInputStream(new FileInputStream(filename));
 
 ObjectOutputStream:&nbsp;new ObjectOutputStream(new FileOutputStream(filename, append));
