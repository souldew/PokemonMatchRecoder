matcher: utility_Constants utility_Poke utility_Elect utility_Result utility_PokeDex matcher_TOD_HPcalc_panel matcher_Memo_panel matcher_Matcher MatcherTest

analyzer: utility_Constants utility_Poke utility_Elect utility_Result utility_PokeDex analyzer_Analyzer analyzer_SearchPanel analyzer_Constants analyzer_ResultPanel AnalyzerTest

#実際の動作とjarファイルの作成(Analyzer)
AnalyzerTest:
	jar cf Analyzer.jar analyzer utility
	jar ufm Analyzer.jar analyzer.mani
	java -cp Analyzer.jar analyzer.Analyzer

#実際の動作とjarファイルの作成(Matcher)
MatcherTest:
	jar cf Matcher.jar -C bin matcher -C bin utility
	jar ufm Matcher.jar matcher.mani
	java -cp Matcher.jar matcher.Matcher

#記号とclassファイルの依存
utility_Constants: bin\utility\Constants.class
utility_Poke: bin\utility\Poke.class
utility_Elect: bin\utility\Elect.class
utility_Result: bin\utility\Result.class
utility_PokeDex: bin\utility\PokeDex.class
matcher_Matcher: bin\matcher\Matcher.class
analyzer_Analyzer: bin\analyzer\Analyzer.class
analyzer_SearchPanel: bin\analyzer\SearchPanel.class
analyzer_Constants: bin\analyzer\Constants.class
analyzer_ResultPanel: bin\analyzer\ResultPanel.class
matcher_TOD_HPcalc_panel: bin\matcher\TOD_HPcalc_panel.class
matcher_Memo_panel: bin\matcher\Memo_panel.class

#classファイルとjavaファイルの依存関係
utility\Constants.class: utility\Constants.java
	javac utility\Constants.java
utility\Poke.class: utility\Poke.java
	javac utility\Poke.java
utility\Elect.class: utility\Elect.java
	javac utility\Elect.java
utility\Result.class: utility\Result.java
	javac utility\Result.java
utility\PokeDex.class: utility\PokeDex.java
	javac utility\PokeDex.java
matcher\Matcher.class: matcher\Matcher.java
	javac matcher\Matcher.java
analyzer\Analyzer.class: analyzer\Analyzer.java
	javac analyzer\Analyzer.java
analyzer\SearchPanel.class: analyzer\SearchPanel.java
	javac analyzer\SearchPanel.java
analyzer\Constants.class: analyzer\Constants.java
	javac analyzer\Constants.java
analyzer\ResultPanel.class: analyzer\ResultPanel.java
	javac analyzer\ResultPanel.java
matcher\TOD_HPcalc_panel.class:  matcher\TOD_HPcalc_panel.java
	javac matcher\TOD_HPcalc_panel.java
matcher\Memo_panel.class: matcher\Memo_panel.java
	javac matcher\Memo_panel.java


#preview: utility\Constants.class
#
#utility\Constants.class: utility\Constants.java
#	javac utility\Constants.java
#	javac utility\Poke.java
#	javac utility\Elect.java
#	javac utility\Result.java
#	javac utility\PokeDex.java
#	javac matcher\Matcher.java
#java matcher.Matcher
#	jar cf Matcher.jar matcher utility
#	jar ufm Matcher.jar matcher.mani
#	java -cp Matcher.jar matcher.Matcher