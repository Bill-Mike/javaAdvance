文件流测试包，其中test.txt为测试文件

字符流与字节流的区别：
1.字节流没有使用缓冲区，字符流使用了缓冲区
2.字符流更适合中文文件的操作

使用OutputStream字节输出流作为输出是，不进行close()，目标文件中以然可以显示输出结果，
使用Writer字符输出流作为输出是不进行close(),目标文件中没有输出结果，因为writer使用了缓冲区，使用close()方法将强制执行刷新机制，如果没有使用时close()方法将无法进行输出，如果不适用close（可以使用flush()方法井型强制刷新


内存操作流：
将读取到的流信息存储到内存中
在Java中有两类内存操作流：
字节内存操作流：ByteArrayOutputStream, ByteArrayInputStream
字符内存操作流：CharArrayWriter, CharArrayReader