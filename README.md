<p class="has-line-data" data-line-start="0" data-line-end="2">Версия java: 21<br>
Система сборки: maven(Apache Maven 3.9.5)</p>
<p class="has-line-data" data-line-start="3" data-line-end="4">Инструкция для сборки: в папке с файлом pom.xml введите команду mvn package</p>
<p class="has-line-data" data-line-start="5" data-line-end="6">Интсрукция по запyску:</p>
<ol>
<li class="has-line-data" data-line-start="6" data-line-end="7">Ввод исполняемого файла: java -jar target/SymbolSplitter-1.0-SNAPSHOT.jar</li>
<li class="has-line-data" data-line-start="7" data-line-end="12">Указание ключей:
<ol>
<li class="has-line-data" data-line-start="8" data-line-end="9">-s или -f для выбора вида статистики(если введены оба ключа, то будет полная статистика, если же ни один ключ не введен, то бует выведена краткая статистика), -s ключ указывает на выбор краткой, а -f на выбор полной статистики</li>
<li class="has-line-data" data-line-start="9" data-line-end="10">-p с последующей строчкой, для добавления префикса ввиде последующей строчки к выходным файлам, если есть ключ -p то последующая строчка будет восприниматься как префикс</li>
<li class="has-line-data" data-line-start="10" data-line-end="11">-o с последующей строчкой, для добавления пути для выходных файлов ввиде последующей строчки , если есть ключ -o то последующая строчка будет восприниматься как путь для выходных файлов</li>
<li class="has-line-data" data-line-start="11" data-line-end="12">-a для того, чтобы выбрать режим, при котором результаты дописываются в выходные файлы(по дефолту выходные файлы перизаписываются)</li>
</ol>
</li>
<li class="has-line-data" data-line-start="12" data-line-end="13">Ввод файлов с исходными данными: просто перечислите через пробел имена файлов</li>
</ol>
