jar cf Analyzer.jar -C bin analyzer -C bin utility
jar ufm Analyzer.jar analyzer.mani
java -cp Analyzer.jar analyzer.Analyzer