data class Pessoa(val nome: String, val idade: Int)

fun main() {
    val pessoas = mutableListOf<Pessoa>()

    var opcao: Int
    do {
        println("\n1 - Adicionar pessoa")
        println("2 - Exibir lista de pessoas")
        println("3 - Exibir média de idade")
        println("4 - Buscar pessoa pelo nome")
        println("5 - Remover pessoa pelo nome")
        println("6 - Sair")
        print("Digite uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> {
                print("Digite o nome da pessoa: ")
                val nome = readLine() ?: ""
                print("Digite a idade da pessoa: ")
                val idade = readLine()?.toIntOrNull() ?: 0
                pessoas.add(Pessoa(nome, idade))
            }
            2 -> {
                if (pessoas.isEmpty()) {
                    println("Não há pessoas cadastradas.")
                } else {
                    println("Lista de pessoas:")
                    for (pessoa in pessoas) {
                        println("${pessoa.nome} - ${pessoa.idade} anos")
                    }
                }
            }
            3 -> {
                if (pessoas.isEmpty()) {
                    println("Não há pessoas cadastradas.")
                } else {
                    val somaIdades = pessoas.sumBy { it.idade }
                    val mediaIdade = somaIdades.toDouble() / pessoas.size
                    println("Média de idade: ${mediaIdade.format(2)} anos")
                }
            }
            4 -> {
                print("Digite o nome da pessoa que deseja buscar: ")
                val nomeBusca = readLine() ?: ""
                val pessoaBusca = pessoas.find { it.nome.equals(nomeBusca, ignoreCase = true) }
                if (pessoaBusca == null) {
                    println("Pessoa não encontrada.")
                } else {
                    println("${pessoaBusca.nome} - ${pessoaBusca.idade} anos")
                }
            }
            5 -> {
                print("Digite o nome da pessoa que deseja remover: ")
                val nomeRemocao = readLine() ?: ""
                val pessoaRemocao = pessoas.find { it.nome.equals(nomeRemocao, ignoreCase = true) }
                if (pessoaRemocao == null) {
                    println("Pessoa não encontrada.")
                } else {
                    pessoas.remove(pessoaRemocao)
                    println("Pessoa removida com sucesso.")
                }
            }
            6 -> println("Saindo...")
            else -> println("Opção inválida.")
        }
    } while (opcao != 6)
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)
