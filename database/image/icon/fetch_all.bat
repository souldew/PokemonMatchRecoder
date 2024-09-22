rem 確認済み未回収　アンノーン,トリトドン,メブキジカ,ビビヨン,フラージェス,トリミアン,ポットデス,マホイップ,サトシピカチュウ,サトシゲッコウガ

echo off
rem 基本的なフォルムを回収
for /L %%e in (1,1,9) do (
        curl -o %%ea.png https://www.serebii.net/pokedex-sv/icon/00%%e.png
)
for /L %%e in (10,1,99) do (
        curl -o %%ea.png https://www.serebii.net/pokedex-sv/icon/0%%e.png
)
for /L %%e in (100,1,1025) do (
        curl -o %%ea.png https://www.serebii.net/pokedex-sv/icon/%%e.png
)

rem アローラフォーム
curl -o 19b.png https://www.serebii.net/pokedex-sv/icon/019-a.png
curl -o 20b.png https://www.serebii.net/pokedex-sv/icon/020-a.png
curl -o 26b.png https://www.serebii.net/pokedex-sv/icon/026-a.png
curl -o 27b.png https://www.serebii.net/pokedex-sv/icon/027-a.png
curl -o 28b.png https://www.serebii.net/pokedex-sv/icon/028-a.png
curl -o 37b.png https://www.serebii.net/pokedex-sv/icon/037-a.png
curl -o 38b.png https://www.serebii.net/pokedex-sv/icon/038-a.png
curl -o 50b.png https://www.serebii.net/pokedex-sv/icon/050-a.png
curl -o 51b.png https://www.serebii.net/pokedex-sv/icon/051-a.png
curl -o 52b.png https://www.serebii.net/pokedex-sv/icon/052-a.png
curl -o 53b.png https://www.serebii.net/pokedex-sv/icon/053-a.png
curl -o 74b.png https://www.serebii.net/pokedex-sv/icon/074-a.png
curl -o 75b.png https://www.serebii.net/pokedex-sv/icon/075-a.png
curl -o 76b.png https://www.serebii.net/pokedex-sv/icon/076-a.png
curl -o 88b.png https://www.serebii.net/pokedex-sv/icon/088-a.png
curl -o 89b.png https://www.serebii.net/pokedex-sv/icon/089-a.png
curl -o 103b.png https://www.serebii.net/pokedex-sv/icon/103-a.png
curl -o 105b.png https://www.serebii.net/pokedex-sv/icon/105-a.png

rem ガラルフォーム
curl -o 52c.png https://www.serebii.net/pokedex-sv/icon/052-g.png
curl -o 77b.png https://www.serebii.net/pokedex-sv/icon/077-g.png
curl -o 78b.png https://www.serebii.net/pokedex-sv/icon/078-g.png
curl -o 79b.png https://www.serebii.net/pokedex-sv/icon/079-g.png
curl -o 80c.png https://www.serebii.net/pokedex-sv/icon/080-g.png
curl -o 83b.png https://www.serebii.net/pokedex-sv/icon/083-g.png
curl -o 110b.png https://www.serebii.net/pokedex-sv/icon/110-g.png
curl -o 122b.png https://www.serebii.net/pokedex-sv/icon/122-g.png
curl -o 144b.png https://www.serebii.net/pokedex-sv/icon/144-g.png
curl -o 145b.png https://www.serebii.net/pokedex-sv/icon/145-g.png
curl -o 146b.png https://www.serebii.net/pokedex-sv/icon/146-g.png
curl -o 199b.png https://www.serebii.net/pokedex-sv/icon/199-g.png
curl -o 222b.png https://www.serebii.net/pokedex-sv/icon/222-g.png
curl -o 263b.png https://www.serebii.net/pokedex-sv/icon/263-g.png
curl -o 264b.png https://www.serebii.net/pokedex-sv/icon/264-g.png
curl -o 554b.png https://www.serebii.net/pokedex-sv/icon/554-g.png
curl -o 555b.png https://www.serebii.net/pokedex-sv/icon/555-g.png
curl -o 555d.png https://www.serebii.net/pokedex-sv/icon/555-gz.png
curl -o 562b.png https://www.serebii.net/pokedex-sv/icon/562-g.png
curl -o 618b.png https://www.serebii.net/pokedex-sv/icon/618-g.png

rem メガシンカ
curl -o 3b.png https://www.serebii.net/pokedex-sv/icon/003-m.png
curl -o 6b.png https://www.serebii.net/pokedex-sv/icon/006-mx.png
curl -o 6c.png https://www.serebii.net/pokedex-sv/icon/006-my.png
curl -o 9b.png https://www.serebii.net/pokedex-sv/icon/009-m.png
curl -o 15b.png https://www.serebii.net/pokedex-sv/icon/015-m.png
curl -o 18b.png https://www.serebii.net/pokedex-sv/icon/018-m.png
curl -o 65b.png https://www.serebii.net/pokedex-sv/icon/065-m.png
curl -o 80b.png https://www.serebii.net/pokedex-sv/icon/080-m.png
curl -o 94b.png https://www.serebii.net/pokedex-sv/icon/094-m.png
curl -o 115b.png https://www.serebii.net/pokedex-sv/icon/115-m.png
curl -o 127b.png https://www.serebii.net/pokedex-sv/icon/127-m.png
curl -o 130b.png https://www.serebii.net/pokedex-sv/icon/130-m.png
curl -o 142b.png https://www.serebii.net/pokedex-sv/icon/142-m.png
curl -o 150b.png https://www.serebii.net/pokedex-sv/icon/150-mx.png
curl -o 150c.png https://www.serebii.net/pokedex-sv/icon/150-my.png
curl -o 181b.png https://www.serebii.net/pokedex-sv/icon/181-m.png
curl -o 208b.png https://www.serebii.net/pokedex-sv/icon/208-m.png
curl -o 212b.png https://www.serebii.net/pokedex-sv/icon/212-m.png
curl -o 214b.png https://www.serebii.net/pokedex-sv/icon/214-m.png
curl -o 229b.png https://www.serebii.net/pokedex-sv/icon/229-m.png
curl -o 248b.png https://www.serebii.net/pokedex-sv/icon/248-m.png
curl -o 254b.png https://www.serebii.net/pokedex-sv/icon/254-m.png
curl -o 257b.png https://www.serebii.net/pokedex-sv/icon/257-m.png
curl -o 260b.png https://www.serebii.net/pokedex-sv/icon/260-m.png
curl -o 282b.png https://www.serebii.net/pokedex-sv/icon/282-m.png
curl -o 302b.png https://www.serebii.net/pokedex-sv/icon/302-m.png
curl -o 303b.png https://www.serebii.net/pokedex-sv/icon/303-m.png
curl -o 306b.png https://www.serebii.net/pokedex-sv/icon/306-m.png
curl -o 308b.png https://www.serebii.net/pokedex-sv/icon/308-m.png
curl -o 310b.png https://www.serebii.net/pokedex-sv/icon/310-m.png
curl -o 319b.png https://www.serebii.net/pokedex-sv/icon/319-m.png
curl -o 323b.png https://www.serebii.net/pokedex-sv/icon/323-m.png
curl -o 334b.png https://www.serebii.net/pokedex-sv/icon/334-m.png
curl -o 354b.png https://www.serebii.net/pokedex-sv/icon/354-m.png
curl -o 359b.png https://www.serebii.net/pokedex-sv/icon/359-m.png
curl -o 362b.png https://www.serebii.net/pokedex-sv/icon/362-m.png
curl -o 373b.png https://www.serebii.net/pokedex-sv/icon/373-m.png
curl -o 376b.png https://www.serebii.net/pokedex-sv/icon/376-m.png
curl -o 380b.png https://www.serebii.net/pokedex-sv/icon/380-m.png
curl -o 381b.png https://www.serebii.net/pokedex-sv/icon/381-m.png
curl -o 384b.png https://www.serebii.net/pokedex-sv/icon/384-m.png
curl -o 428b.png https://www.serebii.net/pokedex-sv/icon/428-m.png
curl -o 445b.png https://www.serebii.net/pokedex-sv/icon/445-m.png
curl -o 448b.png https://www.serebii.net/pokedex-sv/icon/448-m.png
curl -o 460b.png https://www.serebii.net/pokedex-sv/icon/460-m.png
curl -o 475b.png https://www.serebii.net/pokedex-sv/icon/475-m.png
curl -o 531b.png https://www.serebii.net/pokedex-sv/icon/531-m.png
curl -o 719b.png https://www.serebii.net/pokedex-sv/icon/719-m.png

rem ゲンシカイキ
rem カイオーガはなぜかm．グラをmにするとnotFoundのため間違い．多分修正される
@REM curl -o 382b.png https://www.serebii.net/pokedex-sv/icon/382-p.png
curl -o 382b.png https://www.serebii.net/pokedex-sv/icon/382-m.png
curl -o 383b.png https://www.serebii.net/pokedex-sv/icon/383-p.png

rem キョダイマックス
curl -o 3c.png https://www.serebii.net/pokedex-sv/icon/003-gi.png
curl -o 9c.png https://www.serebii.net/pokedex-sv/icon/009-gi.png
curl -o 6d.png https://www.serebii.net/pokedex-sv/icon/006-gi.png
curl -o 12b.png https://www.serebii.net/pokedex-sv/icon/012-gi.png
curl -o 25b.png https://www.serebii.net/pokedex-sv/icon/025-gi.png
curl -o 52d.png https://www.serebii.net/pokedex-sv/icon/052-gi.png
curl -o 68b.png https://www.serebii.net/pokedex-sv/icon/068-gi.png
curl -o 94c.png https://www.serebii.net/pokedex-sv/icon/094-gi.png
curl -o 99b.png https://www.serebii.net/pokedex-sv/icon/099-gi.png
curl -o 131b.png https://www.serebii.net/pokedex-sv/icon/131-gi.png
curl -o 133b.png https://www.serebii.net/pokedex-sv/icon/133-gi.png
curl -o 143b.png https://www.serebii.net/pokedex-sv/icon/143-gi.png
curl -o 569b.png https://www.serebii.net/pokedex-sv/icon/569-gi.png
curl -o 809b.png https://www.serebii.net/pokedex-sv/icon/809-gi.png
curl -o 812b.png https://www.serebii.net/pokedex-sv/icon/812-gi.png
curl -o 815b.png https://www.serebii.net/pokedex-sv/icon/815-gi.png
curl -o 818b.png https://www.serebii.net/pokedex-sv/icon/818-gi.png
curl -o 823b.png https://www.serebii.net/pokedex-sv/icon/823-gi.png
curl -o 826b.png https://www.serebii.net/pokedex-sv/icon/826-gi.png
curl -o 834b.png https://www.serebii.net/pokedex-sv/icon/834-gi.png
curl -o 839b.png https://www.serebii.net/pokedex-sv/icon/839-gi.png
curl -o 841b.png https://www.serebii.net/pokedex-sv/icon/841-gi.png
curl -o 842b.png https://www.serebii.net/pokedex-sv/icon/842-gi.png
curl -o 844b.png https://www.serebii.net/pokedex-sv/icon/844-gi.png
curl -o 849c.png https://www.serebii.net/pokedex-sv/icon/849-gi.png
curl -o 851b.png https://www.serebii.net/pokedex-sv/icon/851-gi.png
curl -o 858b.png https://www.serebii.net/pokedex-sv/icon/858-gi.png
curl -o 861b.png https://www.serebii.net/pokedex-sv/icon/861-gi.png
curl -o 869b.png https://www.serebii.net/pokedex-sv/icon/869-gi.png
curl -o 879b.png https://www.serebii.net/pokedex-sv/icon/879-gi.png
curl -o 884b.png https://www.serebii.net/pokedex-sv/icon/884-gi.png
curl -o 892d.png https://www.serebii.net/pokedex-sv/icon/892-gi.png
curl -o 892e.png https://www.serebii.net/pokedex-sv/icon/892-rgi.png

rem PLA系
rem イダイトウ♀
curl -o 902b.png https://www.serebii.net/pokedex-sv/icon/902-f.png
rem 霊獣ラブトロス
curl -o 905b.png https://www.serebii.net/pokedex-sv/icon/905-t.png
rem リージョンヒスイ
curl -o 58b.png https://www.serebii.net/pokedex-sv/icon/058-h.png
curl -o 59b.png https://www.serebii.net/pokedex-sv/icon/059-h.png
curl -o 100b.png https://www.serebii.net/pokedex-sv/icon/100-h.png
curl -o 101b.png https://www.serebii.net/pokedex-sv/icon/101-h.png
curl -o 157b.png https://www.serebii.net/pokedex-sv/icon/157-h.png
curl -o 211b.png https://www.serebii.net/pokedex-sv/icon/211-h.png
curl -o 215b.png https://www.serebii.net/pokedex-sv/icon/215-h.png
curl -o 503b.png https://www.serebii.net/pokedex-sv/icon/503-h.png
curl -o 549b.png https://www.serebii.net/pokedex-sv/icon/549-h.png
curl -o 550c.png https://www.serebii.net/pokedex-sv/icon/550-w.png
curl -o 570b.png https://www.serebii.net/pokedex-sv/icon/570-h.png
curl -o 571b.png https://www.serebii.net/pokedex-sv/icon/571-h.png
curl -o 628b.png https://www.serebii.net/pokedex-sv/icon/628-h.png
curl -o 705b.png https://www.serebii.net/pokedex-sv/icon/705-h.png
curl -o 706b.png https://www.serebii.net/pokedex-sv/icon/706-h.png
curl -o 713b.png https://www.serebii.net/pokedex-sv/icon/713-h.png
curl -o 724b.png https://www.serebii.net/pokedex-sv/icon/724-h.png
rem オリジンディアルガ・パルキア
curl -o 483b.png https://www.serebii.net/pokedex-sv/icon/483-o.png
curl -o 484b.png https://www.serebii.net/pokedex-sv/icon/484-o.png

rem パルデア系
rem パフュートン
curl -o 916b.png https://www.serebii.net/pokedex-sv/icon/916-f.png
rem イルカマンマイティ
curl -o 964b.png https://www.serebii.net/pokedex-sv/icon/964-h.png
rem イキリンコ
curl -o 931b.png https://www.serebii.net/pokedex-sv/icon/931-b.png
curl -o 931c.png https://www.serebii.net/pokedex-sv/icon/931-y.png
curl -o 931d.png https://www.serebii.net/pokedex-sv/icon/931-w.png
rem リージョンパルデア
curl -o 194b.png https://www.serebii.net/pokedex-sv/icon/194-p.png
curl -o 128b.png https://www.serebii.net/pokedex-sv/icon/128-p.png
curl -o 128c.png https://www.serebii.net/pokedex-sv/icon/128-b.png
curl -o 128d.png https://www.serebii.net/pokedex-sv/icon/128-a.png
rem 碧の仮面追加
rem ガチグマ赫月
curl -o 901b.png https://www.serebii.net/pokedex-sv/icon/901-b.png
rem オーガポン仮面違い
curl -o 1017b.png https://www.serebii.net/pokedex-sv/icon/1017-w.png
curl -o 1017c.png https://www.serebii.net/pokedex-sv/icon/1017-h.png
curl -o 1017d.png https://www.serebii.net/pokedex-sv/icon/1017-c.png
rem テラパゴス
curl -o 1024b.png https://www.serebii.net/pokedex-sv/icon/1024-t.png
curl -o 1024c.png https://www.serebii.net/pokedex-sv/icon/1024-s.png


rem バリエーションで性能が変わるポケモン
rem ミノマダム
curl -o 413b.png https://www.serebii.net/pokedex-sv/icon/413-s.png
curl -o 413c.png https://www.serebii.net/pokedex-sv/icon/413-t.png
rem ギラティナ
curl -o 487b.png https://www.serebii.net/pokedex-sv/icon/487-o.png
rem バスラオ
curl -o 550b.png https://www.serebii.net/pokedex-sv/icon/550-b.png
rem ヒヒダルマ_ダルマモード
curl -o 555c.png https://www.serebii.net/pokedex-sv/icon/555-z.png
rem キュレム
curl -o 646b.png https://www.serebii.net/pokedex-sv/icon/646-w.png
curl -o 646c.png https://www.serebii.net/pokedex-sv/icon/646-b.png
rem ニャオニクス♀
curl -o 678b.png https://www.serebii.net/pokedex-sv/icon/678-f.png
rem オドリドリ
curl -o 741b.png https://www.serebii.net/pokedex-sv/icon/741-p.png
curl -o 741c.png https://www.serebii.net/pokedex-sv/icon/741-pau.png
curl -o 741d.png https://www.serebii.net/pokedex-sv/icon/741-s.png
rem ルガルガン
curl -o 745b.png https://www.serebii.net/pokedex-sv/icon/745-m.png
curl -o 745c.png https://www.serebii.net/pokedex-sv/icon/745-d.png
rem ネクロズマ
curl -o 800b.png https://www.serebii.net/pokedex-sv/icon/800-dm.png
curl -o 800c.png https://www.serebii.net/pokedex-sv/icon/800-dw.png
curl -o 800d.png https://www.serebii.net/pokedex-sv/icon/800-u.png
rem ストリンダー
curl -o 849b.png https://www.serebii.net/pokedex-sv/icon/849-l.png
rem イエッサン♀
curl -o 876b.png https://www.serebii.net/pokedex-sv/icon/876-f.png

rem 用途が薄いアイコン系
rem ギルガルド剣
curl -o 681b.png https://www.serebii.net/pokedex-sv/icon/681-b.png
rem バケッチャ_サイズごとに同じ画像を保存
curl -o 710b.png https://www.serebii.net/pokedex-sv/icon/710.png
curl -o 710c.png https://www.serebii.net/pokedex-sv/icon/710.png
curl -o 710d.png https://www.serebii.net/pokedex-sv/icon/710.png
rem パンプジン_サイズごとに同じ画像を保存
curl -o 711b.png https://www.serebii.net/pokedex-sv/icon/711.png
curl -o 711c.png https://www.serebii.net/pokedex-sv/icon/711.png
curl -o 711d.png https://www.serebii.net/pokedex-sv/icon/711.png
rem ヨワシ群れ
curl -o 746b.png https://www.serebii.net/pokedex-sv/icon/746-s.png
rem メテノ核
curl -o 774b.png https://www.serebii.net/pokedex-sv/icon/774-r.png
rem ウーラオス悪、水に同じアイコン
curl -o 892b.png https://www.serebii.net/pokedex-sv/icon/892.png
curl -o 892c.png https://www.serebii.net/pokedex-sv/icon/892.png

rem フォルムチェンジ系
rem デオキシス
curl -o 386b.png https://www.serebii.net/pokedex-sv/icon/386-a.png
curl -o 386c.png https://www.serebii.net/pokedex-sv/icon/386-d.png
curl -o 386d.png https://www.serebii.net/pokedex-sv/icon/386-s.png
rem ロトム
curl -o 479b.png https://www.serebii.net/pokedex-sv/icon/479-w.png
curl -o 479c.png https://www.serebii.net/pokedex-sv/icon/479-h.png
curl -o 479d.png https://www.serebii.net/pokedex-sv/icon/479-m.png
curl -o 479e.png https://www.serebii.net/pokedex-sv/icon/479-s.png
curl -o 479f.png https://www.serebii.net/pokedex-sv/icon/479-f.png
rem シェイミ
curl -o 492b.png https://www.serebii.net/pokedex-sv/icon/492-s.png
rem トルネロス,ボルトロス,ランドロス
curl -o 641b.png https://www.serebii.net/pokedex-sv/icon/641-s.png
curl -o 642b.png https://www.serebii.net/pokedex-sv/icon/642-s.png
curl -o 645b.png https://www.serebii.net/pokedex-sv/icon/645-s.png
rem ケルディオ
curl -o 647b.png https://www.serebii.net/pokedex-sv/icon/647-r.png
rem メロエッタ
curl -o 648b.png https://www.serebii.net/pokedex-sv/icon/648-p.png
rem ジガルデ
curl -o 718b.png https://www.serebii.net/pokedex-sv/icon/718-10.png
curl -o 718c.png https://www.serebii.net/pokedex-sv/icon/718-c.png
rem フーパ
curl -o 720b.png https://www.serebii.net/pokedex-sv/icon/720-u.png
rem ザシアン
curl -o 888b.png https://www.serebii.net/pokedex-sv/icon/888-c.png
rem ザマゼンタ
curl -o 889b.png https://www.serebii.net/pokedex-sv/icon/889-c.png
rem バドレックス
curl -o 898b.png https://www.serebii.net/pokedex-sv/icon/898-i.png
curl -o 898c.png https://www.serebii.net/pokedex-sv/icon/898-s.png
rem ムゲンダイナ
curl -o 890b.png https://www.serebii.net/pokedex-sv/icon/890-e.png
echo on

