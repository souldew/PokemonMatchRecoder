import time
import requests

sleep_time_sec = 0.5
max_retry_count = 3

def fetchIcon(file_name, url):
    for retry_count in range(4):
        try:
            response = requests.get(url)
            image = response.content
            with open(file_name, "wb") as aaa:
                aaa.write(image)
            time.sleep(sleep_time_sec)
            break
        except requests.RequestException as e:
            print(f"Error: {url} | {retry_count} / {max_retry_count}")
            if (retry_count < max_retry_count):
                continue
        except KeyboardInterrupt:
            print("\nプログラムを終了します...")
            raise  # KeyboardInterrupt 例外を再度発生させてプログラムを終了
        
    
for id in range(1, 1026, 1):
    file_name = f"{id}a.png"
    uri = f"https://www.serebii.net/pokedex-sv/icon/{str(id).zfill(3)}.png"
    fetchIcon(file_name, uri)


urls = [
    # アローラフォーム
    ["19b.png", "https://www.serebii.net/pokedex-sv/icon/019-a.png"],
    ["20b.png", "https://www.serebii.net/pokedex-sv/icon/020-a.png"],
    ["26b.png", "https://www.serebii.net/pokedex-sv/icon/026-a.png"],
    ["27b.png", "https://www.serebii.net/pokedex-sv/icon/027-a.png"],
    ["28b.png", "https://www.serebii.net/pokedex-sv/icon/028-a.png"],
    ["37b.png", "https://www.serebii.net/pokedex-sv/icon/037-a.png"],
    ["38b.png", "https://www.serebii.net/pokedex-sv/icon/038-a.png"],
    ["50b.png", "https://www.serebii.net/pokedex-sv/icon/050-a.png"],
    ["51b.png", "https://www.serebii.net/pokedex-sv/icon/051-a.png"],
    ["52b.png", "https://www.serebii.net/pokedex-sv/icon/052-a.png"],
    ["53b.png", "https://www.serebii.net/pokedex-sv/icon/053-a.png"],
    ["74b.png", "https://www.serebii.net/pokedex-sv/icon/074-a.png"],
    ["75b.png", "https://www.serebii.net/pokedex-sv/icon/075-a.png"],
    ["76b.png", "https://www.serebii.net/pokedex-sv/icon/076-a.png"],
    ["88b.png", "https://www.serebii.net/pokedex-sv/icon/088-a.png"],
    ["89b.png", "https://www.serebii.net/pokedex-sv/icon/089-a.png"],
    ["103b.png", "https://www.serebii.net/pokedex-sv/icon/103-a.png"],
    ["105b.png", "https://www.serebii.net/pokedex-sv/icon/105-a.png"],
    # ガラルフォーム
    ["52c.png", "https://www.serebii.net/pokedex-sv/icon/052-g.png"],
    ["77b.png", "https://www.serebii.net/pokedex-sv/icon/077-g.png"],
    ["78b.png", "https://www.serebii.net/pokedex-sv/icon/078-g.png"],
    ["79b.png", "https://www.serebii.net/pokedex-sv/icon/079-g.png"],
    ["80c.png", "https://www.serebii.net/pokedex-sv/icon/080-g.png"],
    ["83b.png", "https://www.serebii.net/pokedex-sv/icon/083-g.png"],
    ["110b.png", "https://www.serebii.net/pokedex-sv/icon/110-g.png"],
    ["122b.png", "https://www.serebii.net/pokedex-sv/icon/122-g.png"],
    ["144b.png", "https://www.serebii.net/pokedex-sv/icon/144-g.png"],
    ["145b.png", "https://www.serebii.net/pokedex-sv/icon/145-g.png"],
    ["146b.png", "https://www.serebii.net/pokedex-sv/icon/146-g.png"],
    ["199b.png", "https://www.serebii.net/pokedex-sv/icon/199-g.png"],
    ["222b.png", "https://www.serebii.net/pokedex-sv/icon/222-g.png"],
    ["263b.png", "https://www.serebii.net/pokedex-sv/icon/263-g.png"],
    ["264b.png", "https://www.serebii.net/pokedex-sv/icon/264-g.png"],
    ["554b.png", "https://www.serebii.net/pokedex-sv/icon/554-g.png"],
    ["555b.png", "https://www.serebii.net/pokedex-sv/icon/555-g.png"],
    ["555d.png", "https://www.serebii.net/pokedex-sv/icon/555-gz.png"],
    ["562b.png", "https://www.serebii.net/pokedex-sv/icon/562-g.png"],
    ["618b.png", "https://www.serebii.net/pokedex-sv/icon/618-g.png"],
    # メガシンカ
    ["3b.png", "https://www.serebii.net/pokedex-sv/icon/003-m.png"],
    ["6b.png", "https://www.serebii.net/pokedex-sv/icon/006-mx.png"],
    ["6c.png", "https://www.serebii.net/pokedex-sv/icon/006-my.png"],
    ["9b.png", "https://www.serebii.net/pokedex-sv/icon/009-m.png"],
    ["15b.png", "https://www.serebii.net/pokedex-sv/icon/015-m.png"],
    ["18b.png", "https://www.serebii.net/pokedex-sv/icon/018-m.png"],
    ["65b.png", "https://www.serebii.net/pokedex-sv/icon/065-m.png"],
    ["80b.png", "https://www.serebii.net/pokedex-sv/icon/080-m.png"],
    ["94b.png", "https://www.serebii.net/pokedex-sv/icon/094-m.png"],
    ["115b.png", "https://www.serebii.net/pokedex-sv/icon/115-m.png"],
    ["127b.png", "https://www.serebii.net/pokedex-sv/icon/127-m.png"],
    ["130b.png", "https://www.serebii.net/pokedex-sv/icon/130-m.png"],
    ["142b.png", "https://www.serebii.net/pokedex-sv/icon/142-m.png"],
    ["150b.png", "https://www.serebii.net/pokedex-sv/icon/150-mx.png"],
    ["150c.png", "https://www.serebii.net/pokedex-sv/icon/150-my.png"],
    ["181b.png", "https://www.serebii.net/pokedex-sv/icon/181-m.png"],
    ["208b.png", "https://www.serebii.net/pokedex-sv/icon/208-m.png"],
    ["212b.png", "https://www.serebii.net/pokedex-sv/icon/212-m.png"],
    ["214b.png", "https://www.serebii.net/pokedex-sv/icon/214-m.png"],
    ["229b.png", "https://www.serebii.net/pokedex-sv/icon/229-m.png"],
    ["248b.png", "https://www.serebii.net/pokedex-sv/icon/248-m.png"],
    ["254b.png", "https://www.serebii.net/pokedex-sv/icon/254-m.png"],
    ["257b.png", "https://www.serebii.net/pokedex-sv/icon/257-m.png"],
    ["260b.png", "https://www.serebii.net/pokedex-sv/icon/260-m.png"],
    ["282b.png", "https://www.serebii.net/pokedex-sv/icon/282-m.png"],
    ["302b.png", "https://www.serebii.net/pokedex-sv/icon/302-m.png"],
    ["303b.png", "https://www.serebii.net/pokedex-sv/icon/303-m.png"],
    ["306b.png", "https://www.serebii.net/pokedex-sv/icon/306-m.png"],
    ["308b.png", "https://www.serebii.net/pokedex-sv/icon/308-m.png"],
    ["310b.png", "https://www.serebii.net/pokedex-sv/icon/310-m.png"],
    ["319b.png", "https://www.serebii.net/pokedex-sv/icon/319-m.png"],
    ["323b.png", "https://www.serebii.net/pokedex-sv/icon/323-m.png"],
    ["334b.png", "https://www.serebii.net/pokedex-sv/icon/334-m.png"],
    ["354b.png", "https://www.serebii.net/pokedex-sv/icon/354-m.png"],
    ["359b.png", "https://www.serebii.net/pokedex-sv/icon/359-m.png"],
    ["362b.png", "https://www.serebii.net/pokedex-sv/icon/362-m.png"],
    ["373b.png", "https://www.serebii.net/pokedex-sv/icon/373-m.png"],
    ["376b.png", "https://www.serebii.net/pokedex-sv/icon/376-m.png"],
    ["380b.png", "https://www.serebii.net/pokedex-sv/icon/380-m.png"],
    ["381b.png", "https://www.serebii.net/pokedex-sv/icon/381-m.png"],
    ["384b.png", "https://www.serebii.net/pokedex-sv/icon/384-m.png"],
    ["428b.png", "https://www.serebii.net/pokedex-sv/icon/428-m.png"],
    ["445b.png", "https://www.serebii.net/pokedex-sv/icon/445-m.png"],
    ["448b.png", "https://www.serebii.net/pokedex-sv/icon/448-m.png"],
    ["460b.png", "https://www.serebii.net/pokedex-sv/icon/460-m.png"],
    ["475b.png", "https://www.serebii.net/pokedex-sv/icon/475-m.png"],
    ["531b.png", "https://www.serebii.net/pokedex-sv/icon/531-m.png"],
    ["719b.png", "https://www.serebii.net/pokedex-sv/icon/719-m.png"],
    # ゲンシカイキ
    # カイオーガはなぜかm．グラをmにするとnotFoundのため間違い．多分修正される(2024-09-22)
    ["382b.png", "https://www.serebii.net/pokedex-sv/icon/382-m.png"],
    ["383b.png", "https://www.serebii.net/pokedex-sv/icon/383-p.png"],
    # キョダイマックス
    ["3c.png", "https://www.serebii.net/pokedex-sv/icon/003-gi.png"],
    ["9c.png", "https://www.serebii.net/pokedex-sv/icon/009-gi.png"],
    ["6d.png", "https://www.serebii.net/pokedex-sv/icon/006-gi.png"],
    ["12b.png", "https://www.serebii.net/pokedex-sv/icon/012-gi.png"],
    ["25b.png", "https://www.serebii.net/pokedex-sv/icon/025-gi.png"],
    ["52d.png", "https://www.serebii.net/pokedex-sv/icon/052-gi.png"],
    ["68b.png", "https://www.serebii.net/pokedex-sv/icon/068-gi.png"],
    ["94c.png", "https://www.serebii.net/pokedex-sv/icon/094-gi.png"],
    ["99b.png", "https://www.serebii.net/pokedex-sv/icon/099-gi.png"],
    ["131b.png", "https://www.serebii.net/pokedex-sv/icon/131-gi.png"],
    ["133b.png", "https://www.serebii.net/pokedex-sv/icon/133-gi.png"],
    ["143b.png", "https://www.serebii.net/pokedex-sv/icon/143-gi.png"],
    ["569b.png", "https://www.serebii.net/pokedex-sv/icon/569-gi.png"],
    ["809b.png", "https://www.serebii.net/pokedex-sv/icon/809-gi.png"],
    ["812b.png", "https://www.serebii.net/pokedex-sv/icon/812-gi.png"],
    ["815b.png", "https://www.serebii.net/pokedex-sv/icon/815-gi.png"],
    ["818b.png", "https://www.serebii.net/pokedex-sv/icon/818-gi.png"],
    ["823b.png", "https://www.serebii.net/pokedex-sv/icon/823-gi.png"],
    ["826b.png", "https://www.serebii.net/pokedex-sv/icon/826-gi.png"],
    ["834b.png", "https://www.serebii.net/pokedex-sv/icon/834-gi.png"],
    ["839b.png", "https://www.serebii.net/pokedex-sv/icon/839-gi.png"],
    ["841b.png", "https://www.serebii.net/pokedex-sv/icon/841-gi.png"],
    ["842b.png", "https://www.serebii.net/pokedex-sv/icon/842-gi.png"],
    ["844b.png", "https://www.serebii.net/pokedex-sv/icon/844-gi.png"],
    ["849c.png", "https://www.serebii.net/pokedex-sv/icon/849-gi.png"],
    ["851b.png", "https://www.serebii.net/pokedex-sv/icon/851-gi.png"],
    ["858b.png", "https://www.serebii.net/pokedex-sv/icon/858-gi.png"],
    ["861b.png", "https://www.serebii.net/pokedex-sv/icon/861-gi.png"],
    ["869b.png", "https://www.serebii.net/pokedex-sv/icon/869-gi.png"],
    ["879b.png", "https://www.serebii.net/pokedex-sv/icon/879-gi.png"],
    ["884b.png", "https://www.serebii.net/pokedex-sv/icon/884-gi.png"],
    ["892d.png", "https://www.serebii.net/pokedex-sv/icon/892-gi.png"],
    ["892e.png", "https://www.serebii.net/pokedex-sv/icon/892-rgi.png"],
    # PLA系
    # イダイトウ♀
    ["902b.png", "https://www.serebii.net/pokedex-sv/icon/902-f.png"],
    # 霊獣ラブトロス
    ["905b.png", "https://www.serebii.net/pokedex-sv/icon/905-t.png"],
    # リージョンヒスイ
    ["58b.png", "https://www.serebii.net/pokedex-sv/icon/058-h.png"],
    ["59b.png", "https://www.serebii.net/pokedex-sv/icon/059-h.png"],
    ["100b.png", "https://www.serebii.net/pokedex-sv/icon/100-h.png"],
    ["101b.png", "https://www.serebii.net/pokedex-sv/icon/101-h.png"],
    ["157b.png", "https://www.serebii.net/pokedex-sv/icon/157-h.png"],
    ["211b.png", "https://www.serebii.net/pokedex-sv/icon/211-h.png"],
    ["215b.png", "https://www.serebii.net/pokedex-sv/icon/215-h.png"],
    ["503b.png", "https://www.serebii.net/pokedex-sv/icon/503-h.png"],
    ["549b.png", "https://www.serebii.net/pokedex-sv/icon/549-h.png"],
    ["550c.png", "https://www.serebii.net/pokedex-sv/icon/550-w.png"],
    ["570b.png", "https://www.serebii.net/pokedex-sv/icon/570-h.png"],
    ["571b.png", "https://www.serebii.net/pokedex-sv/icon/571-h.png"],
    ["628b.png", "https://www.serebii.net/pokedex-sv/icon/628-h.png"],
    ["705b.png", "https://www.serebii.net/pokedex-sv/icon/705-h.png"],
    ["706b.png", "https://www.serebii.net/pokedex-sv/icon/706-h.png"],
    ["713b.png", "https://www.serebii.net/pokedex-sv/icon/713-h.png"],
    ["724b.png", "https://www.serebii.net/pokedex-sv/icon/724-h.png"],
    # オリジンディアルガ・パルキア
    ["483b.png", "https://www.serebii.net/pokedex-sv/icon/483-o.png"],
    ["484b.png", "https://www.serebii.net/pokedex-sv/icon/484-o.png"],
    # パルデア系
    # パフュートン
    ["916b.png", "https://www.serebii.net/pokedex-sv/icon/916-f.png"],
    # イルカマンマイティ
    ["964b.png", "https://www.serebii.net/pokedex-sv/icon/964-h.png"],
    # イキリンコ
    ["931b.png", "https://www.serebii.net/pokedex-sv/icon/931-b.png"],
    ["931c.png", "https://www.serebii.net/pokedex-sv/icon/931-y.png"],
    ["931d.png", "https://www.serebii.net/pokedex-sv/icon/931-w.png"],
    # リージョンパルデア
    ["194b.png", "https://www.serebii.net/pokedex-sv/icon/194-p.png"],
    ["128b.png", "https://www.serebii.net/pokedex-sv/icon/128-p.png"],
    ["128c.png", "https://www.serebii.net/pokedex-sv/icon/128-b.png"],
    ["128d.png", "https://www.serebii.net/pokedex-sv/icon/128-a.png"],
    # 碧の仮面
    # ガチグマ赫月
    ["901b.png", "https://www.serebii.net/pokedex-sv/icon/901-b.png"],
    # オーガポン仮面違い
    ["1017b.png", "https://www.serebii.net/pokedex-sv/icon/1017-w.png"],
    ["1017c.png", "https://www.serebii.net/pokedex-sv/icon/1017-h.png"],
    ["1017d.png", "https://www.serebii.net/pokedex-sv/icon/1017-c.png"],
    # テラパゴス
    ["1024b.png", "https://www.serebii.net/pokedex-sv/icon/1024-t.png"],
    ["1024c.png", "https://www.serebii.net/pokedex-sv/icon/1024-s.png"],
    
    # バリエーションで性能が変わるポケモン
    # ミノマダム
    ["413b.png", "https://www.serebii.net/pokedex-sv/icon/413-s.png"],
    ["413c.png", "https://www.serebii.net/pokedex-sv/icon/413-t.png"],
    # ギラティナ
    ["487b.png", "https://www.serebii.net/pokedex-sv/icon/487-o.png"],
    # バスラオ
    ["550b.png", "https://www.serebii.net/pokedex-sv/icon/550-b.png"],
    # ヒヒダルマ_ダルマモード
    ["555c.png", "https://www.serebii.net/pokedex-sv/icon/555-z.png"],
    # キュレム
    ["646b.png", "https://www.serebii.net/pokedex-sv/icon/646-w.png"],
    ["646c.png", "https://www.serebii.net/pokedex-sv/icon/646-b.png"],
    # ニャオニクス♀
    ["678b.png", "https://www.serebii.net/pokedex-sv/icon/678-f.png"],
    # オドリドリ
    ["741b.png", "https://www.serebii.net/pokedex-sv/icon/741-p.png"],
    ["741c.png", "https://www.serebii.net/pokedex-sv/icon/741-pau.png"],
    ["741d.png", "https://www.serebii.net/pokedex-sv/icon/741-s.png"],
    # ルガルガン
    ["745b.png", "https://www.serebii.net/pokedex-sv/icon/745-m.png"],
    ["745c.png", "https://www.serebii.net/pokedex-sv/icon/745-d.png"],
    # ネクロズマ
    ["800b.png", "https://www.serebii.net/pokedex-sv/icon/800-dm.png"],
    ["800c.png", "https://www.serebii.net/pokedex-sv/icon/800-dw.png"],
    ["800d.png", "https://www.serebii.net/pokedex-sv/icon/800-u.png"],
    # ストリンダー
    ["849b.png", "https://www.serebii.net/pokedex-sv/icon/849-l.png"],
    # イエッサン♀
    ["876b.png", "https://www.serebii.net/pokedex-sv/icon/876-f.png"],

    # 用途が薄いアイコン系
    # ギルガルド剣
    ["681b.png", "https://www.serebii.net/pokedex-sv/icon/681-b.png"],
    # バケッチャ_サイズごとに同じ画像を保存
    ["710b.png", "https://www.serebii.net/pokedex-sv/icon/710.png"],
    ["710c.png", "https://www.serebii.net/pokedex-sv/icon/710.png"],
    ["710d.png", "https://www.serebii.net/pokedex-sv/icon/710.png"],
    # パンプジン_サイズごとに同じ画像を保存
    ["711b.png", "https://www.serebii.net/pokedex-sv/icon/711.png"],
    ["711c.png", "https://www.serebii.net/pokedex-sv/icon/711.png"],
    ["711d.png", "https://www.serebii.net/pokedex-sv/icon/711.png"],
    # ヨワシ群れ
    ["746b.png", "https://www.serebii.net/pokedex-sv/icon/746-s.png"],
    # メテノ核
    ["774b.png", "https://www.serebii.net/pokedex-sv/icon/774-r.png"],
    # ウーラオス悪、水に同じアイコン
    ["892b.png", "https://www.serebii.net/pokedex-sv/icon/892.png"],
    ["892c.png", "https://www.serebii.net/pokedex-sv/icon/892.png"],

    # フォルムチェンジ系
    # デオキシス
    ["386b.png", "https://www.serebii.net/pokedex-sv/icon/386-a.png"],
    ["386c.png", "https://www.serebii.net/pokedex-sv/icon/386-d.png"],
    ["386d.png", "https://www.serebii.net/pokedex-sv/icon/386-s.png"],
    # ロトム
    ["479b.png", "https://www.serebii.net/pokedex-sv/icon/479-w.png"],
    ["479c.png", "https://www.serebii.net/pokedex-sv/icon/479-h.png"],
    ["479d.png", "https://www.serebii.net/pokedex-sv/icon/479-m.png"],
    ["479e.png", "https://www.serebii.net/pokedex-sv/icon/479-s.png"],
    ["479f.png", "https://www.serebii.net/pokedex-sv/icon/479-f.png"],
    # シェイミ
    ["492b.png", "https://www.serebii.net/pokedex-sv/icon/492-s.png"],
    # トルネロス,ボルトロス,ランドロス
    ["641b.png", "https://www.serebii.net/pokedex-sv/icon/641-s.png"],
    ["642b.png", "https://www.serebii.net/pokedex-sv/icon/642-s.png"],
    ["645b.png", "https://www.serebii.net/pokedex-sv/icon/645-s.png"],
    # ケルディオ
    ["647b.png", "https://www.serebii.net/pokedex-sv/icon/647-r.png"],
    # メロエッタ
    ["648b.png", "https://www.serebii.net/pokedex-sv/icon/648-p.png"],
    # ジガルデ
    ["718b.png", "https://www.serebii.net/pokedex-sv/icon/718-10.png"],
    ["718c.png", "https://www.serebii.net/pokedex-sv/icon/718-c.png"],
    # フーパ
    ["720b.png", "https://www.serebii.net/pokedex-sv/icon/720-u.png"],
    # ザシアン
    ["888b.png", "https://www.serebii.net/pokedex-sv/icon/888-c.png"],
    # ザマゼンタ
    ["889b.png", "https://www.serebii.net/pokedex-sv/icon/889-c.png"],
    # バドレックス
    ["898b.png", "https://www.serebii.net/pokedex-sv/icon/898-i.png"],
    ["898c.png", "https://www.serebii.net/pokedex-sv/icon/898-s.png"],
    # ムゲンダイナ
    ["890b.png", "https://www.serebii.net/pokedex-sv/icon/890-e.png"],
]

for file_name, url in urls:
    fetchIcon(file_name, url)