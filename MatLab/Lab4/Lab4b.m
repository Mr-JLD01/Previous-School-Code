% John Luke Denny
% CSC 2262
% cs226224
% Lab 4b

%Calulates forces given angles and three known forces

degToRad = pi/180;

alpha = 65 * degToRad;
beta = 76 * degToRad;
gamma = 34 * degToRad;
delta = 49 * degToRad;
epsilon = 24 * degToRad;

W = 295;
G = 315;
H = 365;

Net = [0; 0; 0; W; 0; 0; H; 0; 0; G];

Fv = [  1,  0,  cos(alpha), 0,              0,              0,              0,              0, 0, 0;
        0,  0,  sin(alpha), 0,              0,              0,              0,              0, 0, 1;
        -1, 1,  0,          -cos(beta),     cos(gamma),     0,              0,              0, 0, 0;
        0,  0,  0,          sin(beta),      sin(gamma),     0,              0,              0, 0, 0;
        0,  -1, 0,          0,              0,              -cos(delta),    0,              0, 1, 0;
        0,  0,  0,          0,              0,              sin(delta),     0,              1, 0, 0;
        0,  0,  -cos(alpha), cos(beta),     0,              0,              cos(epsilon),   0, 0, 0;
        0,  0,  -sin(alpha), -sin(beta),    0,              0,              -sin(epsilon),  0, 0, 0;
        0,  0,  0,          0,              -cos(gamma),    cos(delta),     -cos(epsilon),  0, 0, 0;
        0,  0,  0,          0,              -sin(gamma),    -sin(delta),    sin(epsilon),   0, 0, 0];

F = inv(Fv) * Net