command /hologram [<text>] [<text>] [<text>]:
	trigger:
		if the argument 1 is not set:
			send "/hologram stworz <tekst>" to the player
			send "/hologram usun <id>" to the player
			send "/hologram edytujtekst <id> <tekst>" to the player
			send "/hologram showlist" to the player
		if the argument 1 is "stworz":
			if the argument 2 is set:
				add 1 to {id::hologramy}
				set {tekst::%{id::hologramy}%} to the argument 2
				set {lokalizacja::%{id::hologramy}%} to location of the player
				new Hologram "%{id::hologramy}%"
				"%{id::hologramy}%".change{"%{tekst::%{id::hologramy}%}%"}
				"%{id::hologramy}%".display{"%{lokalizacja::%{id::hologramy}%}%"}
				send "&7» &3Utworzyles nowy hologram&7." to the player
			else:
				send "&cNie podales tekstu" to the player
		if the argument 1 is "edytujtekst":
			if the argument 2 is set:
				if the argument 2 is integer:
					if the argument 2 parsed as integer is between 1 and {id::hologramy}:
						if the argument 3 parsed as text is set:
							"%the argument 2 parsed as integer%".change{"%the argument 3%"}
							"%the argument 2 parsed as integer%".display{"%{lokalizacja::%the argument 2%}%"}
							send "&7» &6Pomyslnie edytowano tekst" to the player
						else:
							send "&cNie podales tekstu" to the player
					else:
						send "&cLista hologramow nie posiada takiego ID" to the player
				else:
					send "&cNie ma nazw. Sa wylacznie ID" to the player
			else:
				send "&cPodaj ID" to the player
		if the argument 1 is "showlist":
			loop (size of {id::hologramy}) times:
				send "%loop-value%. %{tekst::%loop-value%}%" to the player
		if the argument 1 is "usun":
			if the argument 2 is set:
				if the argument 2 is integer:
					if the argument 2 parsed as integer is between 1 and {id::hologramy}:
						"%the argument 2%".destroy{}
						"%the argument 2%".delete{}
						send "&8» &7Pomyslnie usunieto &3objekt&7." to the player
					else:
						send "&cNiestety, lecz lista hologramow nie posiada takiego ID" to the player
				else:
					send "&cNie ma nazw. Sa wylacznie ID." to the player
			else:
				send "&cPODAJ ID" to the player 
