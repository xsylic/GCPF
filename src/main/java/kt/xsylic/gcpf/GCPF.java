package kt.xsylic.gcpf;

import kt.xsylic.gcpf.document.CPFDocument;
import org.apache.commons.cli.*;

@SuppressWarnings("SpellCheckingInspection")
public class GCPF {

    public static void main(String[] args) {
        var options = new Options();

        options.addOption("g", "generate", false, "Gerar um CPF aleatório");
        options.addOption("v", "validate", true, "Validar o CPF");

        var parser = new DefaultParser();

        try {
            var cmd = parser.parse(options, args);

            if (cmd.hasOption("g")) {
                generateCPF();
            } else if (cmd.hasOption("v")) {
                validateCPF(cmd);
            } else {
                printHelp(options);
            }

        } catch (ParseException e) {
            System.err.println("Erro ao processar os argumentos passados: " + e.getMessage());
            printHelp(options);
        }
    }

    private static void generateCPF() {
        var generatedCPF = CPFDocument.generateCPF();
        System.out.printf("CPF gerado com sucesso: %s", generatedCPF.getFormattedCPF());
    }

    private static void validateCPF(CommandLine cmd) {
        var cpfToValidate = cmd.getOptionValue("v");
        var isValid = CPFDocument.isValid(cpfToValidate);
        System.out.printf("CPF %s é válido: %s%n", cpfToValidate, isValid ? "sim" : "não");
    }

    private static void printHelp(Options options) {
        var formatter = new HelpFormatter();
        formatter.printHelp("GCPF", options);
    }
}