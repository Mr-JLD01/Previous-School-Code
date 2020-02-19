% John Luke Denny
% CSC 2262
% cs226224
% Lab 4a

%Calculates currents given resistances and voltage

R1 = 8;
R2 = 2;
R3 = 4;
R4 = 9;
R5 = 6;
R6 = 1;
R7 = 7;
R8 = 3;
R9 = 5;

V1 = 130;
V2 = 120;
V3 = 170;

R = [R1+R4+R7,  -R4,            0,              -R7,        0,          0;
     -R4,       R2+R4+R5+R8,    -R5,            0,          -R8,        0;
     0,         -R5,            R3+R5+R6+R9,    0,          0,          -R9;
     -R7,       0,              0,              R3+R6+R7,   0,          0;
     0,         -R8,            0,              0,          R4+R5+R8,   -R4;
     0,         0,              -R9,            0,          -R4,        R4+R8+R9];
V = [V1;0;0;-V2;V2;-V3];

I = inv(R) * V

