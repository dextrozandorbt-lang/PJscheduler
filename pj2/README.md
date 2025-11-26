# Process Scheduler - Proyecto 2

**Autores:**
- Michael Chang - Carnet: 24000414
- Miguel Alvarado - Carnet: 24001670
- Sección: D

## Estructura del Proyecto

```
pj2/
├── ProcessScheduler.java           # Clase principal
├── ProcessScheduler                # Script ejecutable
├── scheduler/
│   ├── ProcessGenerator.java       # Generador de procesos
│   ├── Processor.java              # Procesador
│   ├── processing/                 # Tipos de procesos
│   │   ├── SimpleProcess.java
│   │   ├── ArithmeticProcess.java
│   │   ├── IOProcess.java
│   │   ├── ConditionalProcess.java
│   │   ├── LoopProcess.java
│   │   ├── RRProcess.java
│   │   └── PPProcess.java
│   └── scheduling/policies/        # Políticas
│       ├── Enqueable.java
│       ├── Policy.java
│       ├── FCFS.java
│       ├── LCFS.java
│       ├── RoundRobin.java
│       └── PriorityPolicy.java
└── build.sh                        # Script de compilación
```

## Políticas Implementadas

1. **FCFS** - First Come First Served
2. **LCFS** - Last Come First Served
3. **RR** - Round Robin
4. **PP** - Priority Policy

## Compilación

```bash
bash build.sh
```

O manualmente:

```bash
cd /workspaces/PJscheduler/pj2
javac -d . \
    scheduler/processing/SimpleProcess.java \
    scheduler/processing/ArithmeticProcess.java \
    scheduler/processing/IOProcess.java \
    scheduler/processing/ConditionalProcess.java \
    scheduler/processing/LoopProcess.java \
    scheduler/processing/RRProcess.java \
    scheduler/processing/PPProcess.java \
    scheduler/scheduling/policies/Enqueable.java \
    scheduler/scheduling/policies/Policy.java \
    scheduler/scheduling/policies/FCFS.java \
    scheduler/scheduling/policies/LCFS.java \
    scheduler/scheduling/policies/RoundRobin.java \
    scheduler/scheduling/policies/PriorityPolicy.java \
    scheduler/ProcessGenerator.java \
    scheduler/Processor.java \
    ProcessScheduler.java
```

## Ejecución

### Forma 1: Con Java directo (con classpath)
```bash
java -cp . ProcessScheduler -fcfs 1.5-3 2 1 2.5 3
java -cp . ProcessScheduler -rr 1-2.5 1.5 1 3 4 0.5
```

### Forma 2: Con script ejecutable
```bash
chmod +x ProcessScheduler
./ProcessScheduler -fcfs 1.5-3 2 1 2.5 3
./ProcessScheduler -rr 1-2.5 1.5 1 3 4 0.5
```

## Ejemplos

**FCFS:**
```bash
java ProcessScheduler -fcfs 1.5-3 2 1 2.5 3
```

**LCFS:**
```bash
java ProcessScheduler -lcfs 1.5-3 2 1 2.5 3
```

**Round Robin (quantum 0.5s):**
```bash
java ProcessScheduler -rr 1-2.5 1.5 1 3 4 0.5
```

**Priority Policy:**
```bash
java ProcessScheduler -pp 1.5-3 2 1 2.5 3
```

## Parámetros

- `-politica`: Tipo de política (-fcfs, -lcfs, -rr, -pp)
- `rango_tiempo_ingreso`: Rango min-max (ej: 1.5-3)
- `arith`: Tiempo de procesos aritméticos (segundos)
- `io`: Tiempo de procesos I/O (segundos)
- `cond`: Tiempo de procesos condicionales (segundos)
- `loop`: Tiempo de procesos iterativos (segundos)
- `quantum`: Solo para RR (segundos)

## Tipos de Procesos

- **A** - Arithmetic Process (Aritmético)
- **IO** - Input/Output Process (Entrada/Salida)
- **C** - Conditional Process (Condicional)
- **L** - Loop Process (Iterativo)

## Controles

- **q + ENTER**: Detiene la simulación
- Se muestra en tiempo real:
  - Procesos en cola
  - Proceso actual
  - Cantidad de procesos atendidos
  - Política utilizada

## Resumen Final

Al terminar se muestra:
- Política utilizada
- Procesos atendidos completamente
- Procesos en cola sin atender
- Tiempo promedio por proceso
