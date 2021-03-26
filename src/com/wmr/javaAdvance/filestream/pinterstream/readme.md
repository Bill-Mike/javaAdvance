打印流：
OutPutStream,读写文件时只能使用byte[],当系统操作的数据为，long, double, date,的时候只能将数据转为字节数组的形式，太过于麻烦
OutputStream的功能他过于简陋，一般都是用打印流处理打印操作，PrintStream和PrintWriter两个类处理打印